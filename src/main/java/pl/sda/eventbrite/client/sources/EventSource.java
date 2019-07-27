package pl.sda.eventbrite.client.sources;

import pl.sda.eventbrite.client.model.CommonEvent;

import java.time.LocalDate;
import java.util.List;

public interface EventSource {
    List<CommonEvent> findEvents(LocalDate startDate, LocalDate endDate, String city, String name);
}
