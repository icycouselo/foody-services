package com.icycouselo.apiwrapper.respository.entity.extractedrecipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "Extracted Recipes")
@AllArgsConstructor
public class ExtractedRecipe {

  public ExtractedRecipe() {}

  @Id private String id;
  private Boolean vegetarian;
  private Boolean vegan;
  private Boolean glutenFree;
  private Boolean dairyFree;
  private Boolean veryHealthy;
  private Boolean cheap;
  private Boolean veryPopular;
  private Boolean sustainable;
  private Boolean lowFodmap;
  private Integer weightWatcherSmartPoints;
  private String gaps;
  private Integer preparationMinutes;
  private Integer cookingMinutes;
  private Integer aggregateLikes;
  private Integer healthScore;
  private Double pricePerServing;
  private List<ExtendedIngredient> extendedIngredients;
  private String title;
  private Integer readyInMinutes;
  private Integer servings;
  private String sourceUrl;
  private Integer openLicense;
  private String image;
  private String imageType;
  private Object summary;
  private List<Object> cuisines;
  private List<Object> dishTypes;
  private List<Object> diets;
  private List<Object> occasions;
  private String instructions;
  private List<AnalyzedInstruction> analyzedInstructions;
  private Object sourceName;
  private Object creditsText;
  private Object originalId;
  private LocalDateTime created;
}
