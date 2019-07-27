package pl.sda.eventbrite.client.sources.eventbrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EventbriteResponse {
    List<EventBriteEvent> events;
}
