package pl.sda.eventbrite.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonEvent {
    private String name;
    private String city;
    private String description;
}
