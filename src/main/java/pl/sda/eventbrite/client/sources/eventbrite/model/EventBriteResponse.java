package pl.sda.eventbrite.client.sources.eventbrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pl.sda.eventbrite.client.model.CommonEvent;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EventBriteResponse {
    List<EventBriteEvent> events;


    public List<CommonEvent> toCommonModel() {
        return events.stream()
                .map(x -> EventBriteToCommonModelMapper.convertToCommonEvents(x)).
                        collect(Collectors.toList());
    }
}


