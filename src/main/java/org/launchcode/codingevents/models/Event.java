package org.launchcode.codingevents.models;

import jdk.jfr.BooleanFlag;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Address is required!")
    private String address;

    //@AssertTrue(message = "Invalid!")
    @BooleanFlag
    private boolean registrationRequired;

    @Min(1)
    private int numOfAttendees;

    @Future(message = "Date must be future.")
    @DateTimeFormat(pattern = "MM/dd/yy")
    private Date eventDate;

    private String displayDate;


    public Event(String name, String description, String contactEmail, String address, boolean registrationRequired, int numOfAttendees, Date eventDate) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.address = address;
        this.registrationRequired = registrationRequired;
        this.numOfAttendees = numOfAttendees;
        this.eventDate = eventDate;
        this.displayDate = new SimpleDateFormat("MM/dd/yy").format(eventDate);

    }

    public Event() {
        nextId++;
        this.id = nextId;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(Date eventDate) {
        this.displayDate = new SimpleDateFormat("MM/dd/yy").format(eventDate);
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.displayDate = new SimpleDateFormat("MM/dd/yy").format(eventDate);
        this.eventDate = eventDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public Integer getNumOfAttendees() {
        return numOfAttendees;
    }

    public void setNumOfAttendees(Integer numOfAttendees) {
        this.numOfAttendees = numOfAttendees;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
