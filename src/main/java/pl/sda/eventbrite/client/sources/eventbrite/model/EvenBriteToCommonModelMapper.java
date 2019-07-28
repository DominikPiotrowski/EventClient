package pl.sda.eventbrite.client.sources.eventbrite.model;

import pl.sda.eventbrite.client.model.CommonEvent;

 class EvenBriteToCommonModelMapper {

    static CommonEvent convertToCommonEvents(EventBriteEvent event) {

        String city = "";

        if (event.getVenue() != null && event.getVenue().getAddress() != null) {
            city = event.getVenue().getAddress().getCity();
        }

        return new CommonEvent(
                event.getName().getText(),
                city,
                event.getDescription().getText());
    }
}
