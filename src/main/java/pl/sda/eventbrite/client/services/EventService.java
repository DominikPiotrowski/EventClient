package pl.sda.eventbrite.client.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.eventbrite.client.model.CommonEvent;
import pl.sda.eventbrite.client.sources.EventSource;
import pl.sda.eventbrite.client.sources.EventSourceFactory;
import pl.sda.eventbrite.client.sources.SupportedEventSources;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class EventService {
    private EventSourceFactory eventSourceFactory;

    public List<CommonEvent> searchEvents(Map<SearchParameters, Object> parameters) {

        EventSource eventSource = eventSourceFactory.getEventSource(SupportedEventSources.EVENTBRITE);
        return eventSource.findEvents(parameters);
    }
}
