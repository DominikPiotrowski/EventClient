package pl.sda.eventbrite.client.sources.eventbrite;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.sda.eventbrite.client.model.CommonEvent;
import pl.sda.eventbrite.client.sources.EventSource;
import pl.sda.eventbrite.client.sources.eventbrite.model.EventbriteResponse;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class EventbriteSource implements EventSource {

    private RestTemplate restTemplate;
    private String apiToken;
    private String url;

    @Override
    public List<CommonEvent> findEvents(
            LocalDate startDate,
            LocalDate endDate,
            String city,
            String name) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("start_date.range_start", startDate);
        parameters.put("start_date.range_end", endDate);
        parameters.put("location.address", city);
        parameters.put("q", name);
        parameters.put("token", apiToken);

        ResponseEntity<EventbriteResponse> response =
                restTemplate.getForEntity(createUrl(parameters), EventbriteResponse.class);

        return convertToCommonEvents(response.getBody(), city);
    }

    private String createUrl(Map<String, Object> parameters) {
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("?");
        int i = 1;
        for (String key : parameters.keySet()) {
            stringBuilder.append(key).append("=").append(parameters.get(key));
            if (i <= parameters.keySet().size() - 1) {
                stringBuilder.append("&");
                i++;
            }
        }
        return stringBuilder.toString();
    }

    private List<CommonEvent> convertToCommonEvents(EventbriteResponse body,
                                                    final String city
                                                    ) {
        return body.getEvents().stream()
                .map(x -> new CommonEvent(
                        x.getName().getText(),
                        city,
                        x.getDescription().getText())
                ).collect(Collectors.toList());
    }
}