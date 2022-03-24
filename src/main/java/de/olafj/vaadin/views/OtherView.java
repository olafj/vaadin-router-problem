package de.olafj.vaadin.views;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "other/view", layout = MainLayout.class)
public class OtherView extends VerticalLayout {

    public OtherView() {
        add(new Span("other/view"));
    }
}
