package pl.sda.eventbrite.client.sources.eventbrite;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class EventBriteConfig {

    @Value("${eventbrite.api.key}")
    String eventbriteApiKey;

    @Value("${eventbrite.url}")
    String eventbriteUrl;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    EventbriteSource eventbriteSource(RestTemplate restTemplate) {
        return new EventbriteSource(restTemplate, eventbriteApiKey, eventbriteUrl);
    }

}
