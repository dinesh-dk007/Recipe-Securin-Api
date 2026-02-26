package com.securin.recipe.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonPropertyOrder({
        "nutrientsId",
        "calories",
        "carbohydrateContent",
        "proteinContent",
        "fatContent"
})
public class Nutrients{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NutrientsId;

    private String calories;
    private String carbohydrateContent;
    private String proteinContent;
    private String fatContent;

    public Nutrients(){
        this.calories ="500 kcal";
        this.carbohydrateContent = "60 g";
        this.proteinContent = "6 g";
        this.fatContent = "25 g";
    }

}
