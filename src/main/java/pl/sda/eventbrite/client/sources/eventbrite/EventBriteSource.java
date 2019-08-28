package pl.sda.eventbrite.client.sources.eventbrite;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.sda.eventbrite.client.model.CommonEvent;
import pl.sda.eventbrite.client.services.SearchParameters;
import pl.sda.eventbrite.client.sources.EventSource;
import pl.sda.eventbrite.client.sources.eventbrite.model.EventBriteResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class EventBriteSource implements EventSource {

    private RestTemplate restTemplate;
    private String apiToken;
    private String url;

    @Override
    public List<CommonEvent> findEvents(
            Map<SearchParameters, Object> searchParams) {

        Map<String, Object> parameters = new HashMap<>();
        LocalDateTime startDate = ((LocalDate) searchParams.get(SearchParameters.START_DATE)).atTime(0,0,1);
        parameters.put("start_date.range_start", startDate);

        LocalDateTime endDate = ((LocalDate) searchParams.get(SearchParameters.END_DATE)).atTime(23,59, 59);
        parameters.put("start_date.range_end", endDate);

        parameters.put("location.address", searchParams.get(SearchParameters.CITY));
        parameters.put("q", searchParams.get(SearchParameters.NAME));
        parameters.put("token", apiToken);

        ResponseEntity<EventBriteResponse> response =
                restTemplate.getForEntity(createUrl(parameters), EventBriteResponse.class);

        return response.getBody().toCommonModel();
    }

    private String createUrl(Map<String, Object> parameters) {
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("?");
        int i = 1;
        for (String key : parameters.keySet()) {

            if (parameters.get(key) != null) {
                stringBuilder.append(key).append("=").append(parameters.get(key));
                if (i <= parameters.keySet().size() - 1) {
                    stringBuilder.append("&");
                }
                i++;
            }
        }
        return stringBuilder.toString();
    }
}