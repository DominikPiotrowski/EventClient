package pl.sda.eventbrite.client.sources;

import pl.sda.eventbrite.client.model.CommonEvent;
import pl.sda.eventbrite.client.services.SearchParameters;

import java.util.List;
import java.util.Map;

public interface EventSource {
    List<CommonEvent> findEvents(Map<SearchParameters, Object> parameters);
}
