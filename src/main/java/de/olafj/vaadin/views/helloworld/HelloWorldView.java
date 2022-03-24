package de.olafj.vaadin.views.helloworld;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import de.olafj.vaadin.views.MainLayout;
import de.olafj.vaadin.views.overridetarget.OverrideTargetView;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    public HelloWorldView() {

        var info = new Html(
                "<span>" +
                        "(1) check navigation to OtherView.class, go back. it works<br/> " +
                        "(2) override route /:first/:second => DefaultTargetView.class with /:first/:second => OverrideTargetView.class.</br>" +
                        "(1) check navigation to OtherView.class: not working anymore! OverrideTargetView.class called instead.<br/>" +
                        "(3) clear session route-configuration<br/>" +
                        "(1) check navigation to OtherView.class: it works again!" +
                        "</span>");

        add(new Span(info));

        var button = new Button("(2) override route /:first/:second");
        button.addClickListener(clickEvent -> {
            RouteConfiguration.forSessionScope().getHandledRegistry().clean();
            RouteConfiguration.forSessionScope().setRoute(":first/:second", OverrideTargetView.class, MainLayout.class);
        });



        var button2 = new Button("(1) navigate to /other/view");
        button2.addClickListener(clickEvent -> {
            UI.getCurrent().navigate("/other/view");
        });

        var button3 = new Button("(3) clear session route-configuration");
        button3.addClickListener(clickEvent -> {
            RouteConfiguration.forSessionScope().getHandledRegistry().clean();
        });

        add(button2, button, button3);

    }

}
