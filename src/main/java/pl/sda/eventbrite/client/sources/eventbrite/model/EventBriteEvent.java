package pl.sda.eventbrite.client.sources.eventbrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class EventBriteEvent {
    private EventBriteEventName name;
    private EventBriteEventDescription description;
    private EventBriteEventVenue venue;
    private EventBriteEventStartDate start;
    private EventBriteEventEndDate end;
}
