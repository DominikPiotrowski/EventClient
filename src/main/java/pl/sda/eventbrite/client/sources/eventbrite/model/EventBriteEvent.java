package pl.sda.eventbrite.client.sources.eventbrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EventBriteEvent {
    private EventBriteEventName name;
    private EventBriteEventDescription description;
}
