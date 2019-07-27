package pl.sda.eventbrite.client.sources;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.eventbrite.client.model.UnsupportedEventSourceException;

@Component
@AllArgsConstructor
public class EventSourceFactory {

    private EventSource eventBriteSource;

    public EventSource getEventSource(SupportedEventSources supportedEventSources) {
        if (SupportedEventSources.EVENTBRITE.equals(supportedEventSources)) {
            return eventBriteSource;
        } else {
            throw new UnsupportedEventSourceException();
        }
    }
}
