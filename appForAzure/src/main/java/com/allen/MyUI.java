package com.allen;

import java.util.*;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Grid.SelectionMode;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(true);
        Label logo = new Label("<H1>People in Roster</H1> <p/> Please enter the details and click Add  <br>", ContentMode.HTML);
      
        TextField staffNumber = new TextField("Staff Number");
        staffNumber.setMaxLength(5);

        TextField name = new TextField("Staff Name");

        TextField phone = new TextField("Phone number");
        //check the length of string and
   
    
        ComboBox<String> gender = new ComboBox<String>("Gender");
        gender.setItems("female", "male", "other");
        
        Button addButton = new Button("Add");
       

      
        final VerticalLayout vlayout = new VerticalLayout();
 

        List<Person> people = new ArrayList<Person>();
               
        Grid<Person> myGrid = new Grid<> ();

        myGrid.setItems(people);
        myGrid.addColumn(Person::getName).setCaption("Staff Name");
        myGrid.addColumn(Person::getNumber).setCaption("Staff Number");
        myGrid.addColumn(Person::getPhone).setCaption("phone");
        myGrid.addColumn(Person::getGender).setCaption("gender");
        myGrid.setSelectionMode(SelectionMode.MULTI);
        myGrid.setSizeFull();

        Button clear = new Button("Clear");
        clear.addClickListener(e -> {
            myGrid.removeAllColumns();
        
        });  
        addButton.addClickListener(e -> {
            people.add(new Person(name.getValue(), staffNumber.getValue(),phone.getValue(),gender.getValue()));
            myGrid.removeAllColumns();
            myGrid.setItems(people);
            myGrid.addColumn(Person::getName).setCaption("Name");
            myGrid.addColumn(Person::getNumber).setCaption("Staff Number");
            myGrid.addColumn(Person::getPhone).setCaption("phone");
            myGrid.addColumn(Person::getGender).setCaption("gender");

        });  
        vlayout.addComponents(staffNumber, name, phone, gender, addButton,clear);                
        layout.addComponents(logo, vlayout , myGrid); 
           
        setContent(layout);
       
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
