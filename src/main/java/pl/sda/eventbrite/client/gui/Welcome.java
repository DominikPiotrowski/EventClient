package pl.sda.eventbrite.client.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("welcome")
public class Welcome extends VerticalLayout {

    public Welcome() {
        Label welcome = new Label("Welcome to iventApp");
        Button searchEvents = new Button("Register", new Icon(VaadinIcon.ENTER_ARROW));

        searchEvents.addClickListener(e -> {
            searchEvents.getUI().ifPresent(ui -> ui.navigate("search-event-form"));
        });
        add(welcome, searchEvents);
    }
}