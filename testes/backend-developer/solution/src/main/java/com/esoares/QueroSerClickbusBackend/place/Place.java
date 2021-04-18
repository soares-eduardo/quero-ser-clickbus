package com.esoares.QueroSerClickbusBackend.place;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @CreationTimestamp
    @Column(name="createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updateAt")
    private LocalDateTime updatedAt;

    public Place() {

    }

    public Place(Long id, String name, String city, String state) {
        this.id = id;
        this.name = name;
        this.slug = createSlug(name);
        this.city = city;
        this.state = state;
    }

    public Place(String name, String city, String state) {
        this.name = name;
        this.slug = createSlug(name);
        this.city = city;
        this.state = state;
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

    public LocalDateTime getUpdatedAt() {
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

    public void setSlug(String name) {
        this.slug = createSlug(name);
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static String createSlug(String name) {
        if (name.contains(" ")) {
            return name.replace(" ", "-").toLowerCase();
        }
        return name.toLowerCase();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
