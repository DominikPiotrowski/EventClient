package pl.sda.eventbrite.client.sources.eventbrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
class EventBriteEventVenue {
    @JsonProperty("address")
    private EventBriteEventAddress address;
    private String latitude;
    private String longitude;
}