package de.olafj.vaadin.views.defaulttarget;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.olafj.vaadin.views.MainLayout;

@PageTitle("DefaultTarget")
@Route(value = ":first/:second", layout = MainLayout.class)
public class DefaultTargetView extends VerticalLayout implements BeforeEnterObserver {

    public DefaultTargetView() {
        add(new Span("default"));
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        add(new Span(beforeEnterEvent.getRouteParameters().toString()));
    }
}
