package com.esoares.QueroSerClickbusBackend.place;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table
public class Place {
    @Id
    @SequenceGenerator(name = "place_sequence", sequenceName = "place_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place_sequence")
    private Long id;
    private String name;
    private String slug;
    private String city;
    private String state;
    private Date createdAt;
    private String updatedAt;

    public Place() {

    }

    public Place(Long id, String name, String city, String state, String updatedAt) {
        this.id = id;
        this.name = name;
        this.slug = createSlug(name);
        this.city = city;
        this.state = state;
        this.createdAt = new Date(System.currentTimeMillis());
        this.updatedAt = updatedAt;
    }

    public Place(String name, String city, String state, String updatedAt) {
        this.name = name;
        this.slug = createSlug(name);
        this.city = city;
        this.state = state;
        this.createdAt = new Date(System.currentTimeMillis());
        this.updatedAt = updatedAt;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static String createSlug(String name) {
        if (!name.contains(" ")) {
            return name.toLowerCase();
        }
        return name.replace(" ", "-").toLowerCase();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
