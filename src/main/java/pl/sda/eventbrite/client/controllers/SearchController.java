package pl.sda.eventbrite.client.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.eventbrite.client.services.EventService;
import pl.sda.eventbrite.client.model.CommonEvent;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class SearchController {

    private EventService eventService;

    @GetMapping("/events")
    public List<CommonEvent> search(@RequestParam(required = false) LocalDate startDate,
                                    @RequestParam(required = false) LocalDate endDate,
                                    @RequestParam(required = false) String city,
                                    @RequestParam(required = false) String name) {
        return eventService.searchEvents(startDate, endDate, city, name);
    }
}