package pl.sda.eventbrite.client.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.eventbrite.client.services.EventService;
import pl.sda.eventbrite.client.model.CommonEvent;
import pl.sda.eventbrite.client.services.SearchParameters;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class SearchController {

    private EventService eventService;
    @GetMapping("/events")
    public List<CommonEvent> search(@RequestParam(required = false) LocalDate startDate,
                                    @RequestParam(required = false) LocalDate endDate,
                                    @RequestParam(required = false) String city,
                                    @RequestParam(required = false) String name) {
        Map<SearchParameters,Object> parameters = new HashMap<>();
        parameters.put(SearchParameters.START_DATE, startDate);
        parameters.put(SearchParameters.END_DATE, endDate);
        parameters.put(SearchParameters.CITY, city);
        parameters.put(SearchParameters.NAME, name);

        return eventService.searchEvents(parameters);
    }
}