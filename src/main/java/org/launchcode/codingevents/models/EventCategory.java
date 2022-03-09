package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventCategory extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(max = 20, min = 2, message = "Name must be between 2 and 20 characters")
    private String name;

    public EventCategory(String name) {
        this.name =name;
    }

    public EventCategory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
