package com.securin.recipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "recipe")
@JsonPropertyOrder({
        "id",
        "title",
        "cuisine",
        "rating",
        "prep_time",
        "cook_time",
        "total_time",
        "description",
        "nutrients",
        "serves"
})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String cuisine;

    private Double rating;

    @Column(name = "prep_time")
    @JsonProperty("prep_time")
    private int prepTime;

    @Column(name = "cook_time")
    @JsonProperty("cook_time")
    private int cookTime;

    @Column(name = "total_time")
    @JsonProperty("total_time")
    private int totalTime;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrients_id")
    private Nutrients nutrients;

    @JsonProperty("serves")
    private String serves;
    

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCuisine(){
        return cuisine;
    }

    public Double getRating() {
        return rating;
    }

    public int getPrepTime(){
        return prepTime;
    }

    public int getCookTime(){
        return cookTime;
    }

    public int getTotalTime(){
        return totalTime;
    }

    public String getDescription() {
        return description;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public String getServes() {
        return serves;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public void setTotalTime() {
        this.totalTime = prepTime+cookTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }
}
