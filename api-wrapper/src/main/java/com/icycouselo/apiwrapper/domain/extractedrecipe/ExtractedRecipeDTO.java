package com.icycouselo.apiwrapper.domain.extractedrecipe;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "vegetarian",
  "vegan",
  "glutenFree",
  "dairyFree",
  "veryHealthy",
  "cheap",
  "veryPopular",
  "sustainable",
  "lowFodmap",
  "weightWatcherSmartPoints",
  "gaps",
  "preparationMinutes",
  "cookingMinutes",
  "aggregateLikes",
  "healthScore",
  "pricePerServing",
  "extendedIngredients",
  "id",
  "title",
  "readyInMinutes",
  "servings",
  "sourceUrl",
  "openLicense",
  "image",
  "imageType",
  "summary",
  "cuisines",
  "dishTypes",
  "diets",
  "occasions",
  "instructions",
  "analyzedInstructions",
  "sourceName",
  "creditsText",
  "originalId"
})
@Generated("jsonschema2pojo")
public class ExtractedRecipeDTO {

  @JsonProperty("vegetarian")
  private Boolean vegetarian;

  @JsonProperty("vegan")
  private Boolean vegan;

  @JsonProperty("glutenFree")
  private Boolean glutenFree;

  @JsonProperty("dairyFree")
  private Boolean dairyFree;

  @JsonProperty("veryHealthy")
  private Boolean veryHealthy;

  @JsonProperty("cheap")
  private Boolean cheap;

  @JsonProperty("veryPopular")
  private Boolean veryPopular;

  @JsonProperty("sustainable")
  private Boolean sustainable;

  @JsonProperty("lowFodmap")
  private Boolean lowFodmap;

  @JsonProperty("weightWatcherSmartPoints")
  private Integer weightWatcherSmartPoints;

  @JsonProperty("gaps")
  private String gaps;

  @JsonProperty("preparationMinutes")
  private Integer preparationMinutes;

  @JsonProperty("cookingMinutes")
  private Integer cookingMinutes;

  @JsonProperty("aggregateLikes")
  private Integer aggregateLikes;

  @JsonProperty("healthScore")
  private Integer healthScore;

  @JsonProperty("pricePerServing")
  private Double pricePerServing;

  @JsonProperty("extendedIngredients")
  private List<ExtendedIngredient> extendedIngredients = null;

  @JsonIgnore private Integer id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("readyInMinutes")
  private Integer readyInMinutes;

  @JsonProperty("servings")
  private Integer servings;

  @JsonProperty("sourceUrl")
  private String sourceUrl;

  @JsonProperty("openLicense")
  private Integer openLicense;

  @JsonProperty("image")
  private String image;

  @JsonProperty("imageType")
  private String imageType;

  @JsonProperty("summary")
  private Object summary;

  @JsonProperty("cuisines")
  private List<Object> cuisines = null;

  @JsonProperty("dishTypes")
  private List<Object> dishTypes = null;

  @JsonProperty("diets")
  private List<Object> diets = null;

  @JsonProperty("occasions")
  private List<Object> occasions = null;

  @JsonProperty("instructions")
  private String instructions;

  @JsonProperty("analyzedInstructions")
  private List<AnalyzedInstruction> analyzedInstructions = null;

  @JsonProperty("sourceName")
  private Object sourceName;

  @JsonProperty("creditsText")
  private Object creditsText;

  @JsonProperty("originalId")
  private Object originalId;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("vegetarian")
  public Boolean getVegetarian() {
    return vegetarian;
  }

  @JsonProperty("vegetarian")
  public void setVegetarian(Boolean vegetarian) {
    this.vegetarian = vegetarian;
  }

  public ExtractedRecipeDTO withVegetarian(Boolean vegetarian) {
    this.vegetarian = vegetarian;
    return this;
  }

  @JsonProperty("vegan")
  public Boolean getVegan() {
    return vegan;
  }

  @JsonProperty("vegan")
  public void setVegan(Boolean vegan) {
    this.vegan = vegan;
  }

  public ExtractedRecipeDTO withVegan(Boolean vegan) {
    this.vegan = vegan;
    return this;
  }

  @JsonProperty("glutenFree")
  public Boolean getGlutenFree() {
    return glutenFree;
  }

  @JsonProperty("glutenFree")
  public void setGlutenFree(Boolean glutenFree) {
    this.glutenFree = glutenFree;
  }

  public ExtractedRecipeDTO withGlutenFree(Boolean glutenFree) {
    this.glutenFree = glutenFree;
    return this;
  }

  @JsonProperty("dairyFree")
  public Boolean getDairyFree() {
    return dairyFree;
  }

  @JsonProperty("dairyFree")
  public void setDairyFree(Boolean dairyFree) {
    this.dairyFree = dairyFree;
  }

  public ExtractedRecipeDTO withDairyFree(Boolean dairyFree) {
    this.dairyFree = dairyFree;
    return this;
  }

  @JsonProperty("veryHealthy")
  public Boolean getVeryHealthy() {
    return veryHealthy;
  }

  @JsonProperty("veryHealthy")
  public void setVeryHealthy(Boolean veryHealthy) {
    this.veryHealthy = veryHealthy;
  }

  public ExtractedRecipeDTO withVeryHealthy(Boolean veryHealthy) {
    this.veryHealthy = veryHealthy;
    return this;
  }

  @JsonProperty("cheap")
  public Boolean getCheap() {
    return cheap;
  }

  @JsonProperty("cheap")
  public void setCheap(Boolean cheap) {
    this.cheap = cheap;
  }

  public ExtractedRecipeDTO withCheap(Boolean cheap) {
    this.cheap = cheap;
    return this;
  }

  @JsonProperty("veryPopular")
  public Boolean getVeryPopular() {
    return veryPopular;
  }

  @JsonProperty("veryPopular")
  public void setVeryPopular(Boolean veryPopular) {
    this.veryPopular = veryPopular;
  }

  public ExtractedRecipeDTO withVeryPopular(Boolean veryPopular) {
    this.veryPopular = veryPopular;
    return this;
  }

  @JsonProperty("sustainable")
  public Boolean getSustainable() {
    return sustainable;
  }

  @JsonProperty("sustainable")
  public void setSustainable(Boolean sustainable) {
    this.sustainable = sustainable;
  }

  public ExtractedRecipeDTO withSustainable(Boolean sustainable) {
    this.sustainable = sustainable;
    return this;
  }

  @JsonProperty("lowFodmap")
  public Boolean getLowFodmap() {
    return lowFodmap;
  }

  @JsonProperty("lowFodmap")
  public void setLowFodmap(Boolean lowFodmap) {
    this.lowFodmap = lowFodmap;
  }

  public ExtractedRecipeDTO withLowFodmap(Boolean lowFodmap) {
    this.lowFodmap = lowFodmap;
    return this;
  }

  @JsonProperty("weightWatcherSmartPoints")
  public Integer getWeightWatcherSmartPoints() {
    return weightWatcherSmartPoints;
  }

  @JsonProperty("weightWatcherSmartPoints")
  public void setWeightWatcherSmartPoints(Integer weightWatcherSmartPoints) {
    this.weightWatcherSmartPoints = weightWatcherSmartPoints;
  }

  public ExtractedRecipeDTO withWeightWatcherSmartPoints(Integer weightWatcherSmartPoints) {
    this.weightWatcherSmartPoints = weightWatcherSmartPoints;
    return this;
  }

  @JsonProperty("gaps")
  public String getGaps() {
    return gaps;
  }

  @JsonProperty("gaps")
  public void setGaps(String gaps) {
    this.gaps = gaps;
  }

  public ExtractedRecipeDTO withGaps(String gaps) {
    this.gaps = gaps;
    return this;
  }

  @JsonProperty("preparationMinutes")
  public Integer getPreparationMinutes() {
    return preparationMinutes;
  }

  @JsonProperty("preparationMinutes")
  public void setPreparationMinutes(Integer preparationMinutes) {
    this.preparationMinutes = preparationMinutes;
  }

  public ExtractedRecipeDTO withPreparationMinutes(Integer preparationMinutes) {
    this.preparationMinutes = preparationMinutes;
    return this;
  }

  @JsonProperty("cookingMinutes")
  public Integer getCookingMinutes() {
    return cookingMinutes;
  }

  @JsonProperty("cookingMinutes")
  public void setCookingMinutes(Integer cookingMinutes) {
    this.cookingMinutes = cookingMinutes;
  }

  public ExtractedRecipeDTO withCookingMinutes(Integer cookingMinutes) {
    this.cookingMinutes = cookingMinutes;
    return this;
  }

  @JsonProperty("aggregateLikes")
  public Integer getAggregateLikes() {
    return aggregateLikes;
  }

  @JsonProperty("aggregateLikes")
  public void setAggregateLikes(Integer aggregateLikes) {
    this.aggregateLikes = aggregateLikes;
  }

  public ExtractedRecipeDTO withAggregateLikes(Integer aggregateLikes) {
    this.aggregateLikes = aggregateLikes;
    return this;
  }

  @JsonProperty("healthScore")
  public Integer getHealthScore() {
    return healthScore;
  }

  @JsonProperty("healthScore")
  public void setHealthScore(Integer healthScore) {
    this.healthScore = healthScore;
  }

  public ExtractedRecipeDTO withHealthScore(Integer healthScore) {
    this.healthScore = healthScore;
    return this;
  }

  @JsonProperty("pricePerServing")
  public Double getPricePerServing() {
    return pricePerServing;
  }

  @JsonProperty("pricePerServing")
  public void setPricePerServing(Double pricePerServing) {
    this.pricePerServing = pricePerServing;
  }

  public ExtractedRecipeDTO withPricePerServing(Double pricePerServing) {
    this.pricePerServing = pricePerServing;
    return this;
  }

  @JsonProperty("extendedIngredients")
  public List<ExtendedIngredient> getExtendedIngredients() {
    return extendedIngredients;
  }

  @JsonProperty("extendedIngredients")
  public void setExtendedIngredients(List<ExtendedIngredient> extendedIngredients) {
    this.extendedIngredients = extendedIngredients;
  }

  public ExtractedRecipeDTO withExtendedIngredients(List<ExtendedIngredient> extendedIngredients) {
    this.extendedIngredients = extendedIngredients;
    return this;
  }

  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonIgnore
  public void setId(Integer id) {
    this.id = id;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

  public ExtractedRecipeDTO withTitle(String title) {
    this.title = title;
    return this;
  }

  @JsonProperty("readyInMinutes")
  public Integer getReadyInMinutes() {
    return readyInMinutes;
  }

  @JsonProperty("readyInMinutes")
  public void setReadyInMinutes(Integer readyInMinutes) {
    this.readyInMinutes = readyInMinutes;
  }

  public ExtractedRecipeDTO withReadyInMinutes(Integer readyInMinutes) {
    this.readyInMinutes = readyInMinutes;
    return this;
  }

  @JsonProperty("servings")
  public Integer getServings() {
    return servings;
  }

  @JsonProperty("servings")
  public void setServings(Integer servings) {
    this.servings = servings;
  }

  public ExtractedRecipeDTO withServings(Integer servings) {
    this.servings = servings;
    return this;
  }

  @JsonProperty("sourceUrl")
  public String getSourceUrl() {
    return sourceUrl;
  }

  @JsonProperty("sourceUrl")
  public void setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }

  public ExtractedRecipeDTO withSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
    return this;
  }

  @JsonProperty("openLicense")
  public Integer getOpenLicense() {
    return openLicense;
  }

  @JsonProperty("openLicense")
  public void setOpenLicense(Integer openLicense) {
    this.openLicense = openLicense;
  }

  public ExtractedRecipeDTO withOpenLicense(Integer openLicense) {
    this.openLicense = openLicense;
    return this;
  }

  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(String image) {
    this.image = image;
  }

  public ExtractedRecipeDTO withImage(String image) {
    this.image = image;
    return this;
  }

  @JsonProperty("imageType")
  public String getImageType() {
    return imageType;
  }

  @JsonProperty("imageType")
  public void setImageType(String imageType) {
    this.imageType = imageType;
  }

  public ExtractedRecipeDTO withImageType(String imageType) {
    this.imageType = imageType;
    return this;
  }

  @JsonProperty("summary")
  public Object getSummary() {
    return summary;
  }

  @JsonProperty("summary")
  public void setSummary(Object summary) {
    this.summary = summary;
  }

  public ExtractedRecipeDTO withSummary(Object summary) {
    this.summary = summary;
    return this;
  }

  @JsonProperty("cuisines")
  public List<Object> getCuisines() {
    return cuisines;
  }

  @JsonProperty("cuisines")
  public void setCuisines(List<Object> cuisines) {
    this.cuisines = cuisines;
  }

  public ExtractedRecipeDTO withCuisines(List<Object> cuisines) {
    this.cuisines = cuisines;
    return this;
  }

  @JsonProperty("dishTypes")
  public List<Object> getDishTypes() {
    return dishTypes;
  }

  @JsonProperty("dishTypes")
  public void setDishTypes(List<Object> dishTypes) {
    this.dishTypes = dishTypes;
  }

  public ExtractedRecipeDTO withDishTypes(List<Object> dishTypes) {
    this.dishTypes = dishTypes;
    return this;
  }

  @JsonProperty("diets")
  public List<Object> getDiets() {
    return diets;
  }

  @JsonProperty("diets")
  public void setDiets(List<Object> diets) {
    this.diets = diets;
  }

  public ExtractedRecipeDTO withDiets(List<Object> diets) {
    this.diets = diets;
    return this;
  }

  @JsonProperty("occasions")
  public List<Object> getOccasions() {
    return occasions;
  }

  @JsonProperty("occasions")
  public void setOccasions(List<Object> occasions) {
    this.occasions = occasions;
  }

  public ExtractedRecipeDTO withOccasions(List<Object> occasions) {
    this.occasions = occasions;
    return this;
  }

  @JsonProperty("instructions")
  public String getInstructions() {
    return instructions;
  }

  @JsonProperty("instructions")
  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public ExtractedRecipeDTO withInstructions(String instructions) {
    this.instructions = instructions;
    return this;
  }

  @JsonProperty("analyzedInstructions")
  public List<AnalyzedInstruction> getAnalyzedInstructions() {
    return analyzedInstructions;
  }

  @JsonProperty("analyzedInstructions")
  public void setAnalyzedInstructions(List<AnalyzedInstruction> analyzedInstructions) {
    this.analyzedInstructions = analyzedInstructions;
  }

  public ExtractedRecipeDTO withAnalyzedInstructions(
      List<AnalyzedInstruction> analyzedInstructions) {
    this.analyzedInstructions = analyzedInstructions;
    return this;
  }

  @JsonProperty("sourceName")
  public Object getSourceName() {
    return sourceName;
  }

  @JsonProperty("sourceName")
  public void setSourceName(Object sourceName) {
    this.sourceName = sourceName;
  }

  public ExtractedRecipeDTO withSourceName(Object sourceName) {
    this.sourceName = sourceName;
    return this;
  }

  @JsonProperty("creditsText")
  public Object getCreditsText() {
    return creditsText;
  }

  @JsonProperty("creditsText")
  public void setCreditsText(Object creditsText) {
    this.creditsText = creditsText;
  }

  public ExtractedRecipeDTO withCreditsText(Object creditsText) {
    this.creditsText = creditsText;
    return this;
  }

  @JsonProperty("originalId")
  public Object getOriginalId() {
    return originalId;
  }

  @JsonProperty("originalId")
  public void setOriginalId(Object originalId) {
    this.originalId = originalId;
  }

  public ExtractedRecipeDTO withOriginalId(Object originalId) {
    this.originalId = originalId;
    return this;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public ExtractedRecipeDTO withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(ExtractedRecipeDTO.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("vegetarian");
    sb.append('=');
    sb.append(((this.vegetarian == null) ? "<null>" : this.vegetarian));
    sb.append(',');
    sb.append("vegan");
    sb.append('=');
    sb.append(((this.vegan == null) ? "<null>" : this.vegan));
    sb.append(',');
    sb.append("glutenFree");
    sb.append('=');
    sb.append(((this.glutenFree == null) ? "<null>" : this.glutenFree));
    sb.append(',');
    sb.append("dairyFree");
    sb.append('=');
    sb.append(((this.dairyFree == null) ? "<null>" : this.dairyFree));
    sb.append(',');
    sb.append("veryHealthy");
    sb.append('=');
    sb.append(((this.veryHealthy == null) ? "<null>" : this.veryHealthy));
    sb.append(',');
    sb.append("cheap");
    sb.append('=');
    sb.append(((this.cheap == null) ? "<null>" : this.cheap));
    sb.append(',');
    sb.append("veryPopular");
    sb.append('=');
    sb.append(((this.veryPopular == null) ? "<null>" : this.veryPopular));
    sb.append(',');
    sb.append("sustainable");
    sb.append('=');
    sb.append(((this.sustainable == null) ? "<null>" : this.sustainable));
    sb.append(',');
    sb.append("lowFodmap");
    sb.append('=');
    sb.append(((this.lowFodmap == null) ? "<null>" : this.lowFodmap));
    sb.append(',');
    sb.append("weightWatcherSmartPoints");
    sb.append('=');
    sb.append(((this.weightWatcherSmartPoints == null) ? "<null>" : this.weightWatcherSmartPoints));
    sb.append(',');
    sb.append("gaps");
    sb.append('=');
    sb.append(((this.gaps == null) ? "<null>" : this.gaps));
    sb.append(',');
    sb.append("preparationMinutes");
    sb.append('=');
    sb.append(((this.preparationMinutes == null) ? "<null>" : this.preparationMinutes));
    sb.append(',');
    sb.append("cookingMinutes");
    sb.append('=');
    sb.append(((this.cookingMinutes == null) ? "<null>" : this.cookingMinutes));
    sb.append(',');
    sb.append("aggregateLikes");
    sb.append('=');
    sb.append(((this.aggregateLikes == null) ? "<null>" : this.aggregateLikes));
    sb.append(',');
    sb.append("healthScore");
    sb.append('=');
    sb.append(((this.healthScore == null) ? "<null>" : this.healthScore));
    sb.append(',');
    sb.append("pricePerServing");
    sb.append('=');
    sb.append(((this.pricePerServing == null) ? "<null>" : this.pricePerServing));
    sb.append(',');
    sb.append("extendedIngredients");
    sb.append('=');
    sb.append(((this.extendedIngredients == null) ? "<null>" : this.extendedIngredients));
    sb.append(',');
    sb.append("id");
    sb.append('=');
    sb.append(((this.id == null) ? "<null>" : this.id));
    sb.append(',');
    sb.append("title");
    sb.append('=');
    sb.append(((this.title == null) ? "<null>" : this.title));
    sb.append(',');
    sb.append("readyInMinutes");
    sb.append('=');
    sb.append(((this.readyInMinutes == null) ? "<null>" : this.readyInMinutes));
    sb.append(',');
    sb.append("servings");
    sb.append('=');
    sb.append(((this.servings == null) ? "<null>" : this.servings));
    sb.append(',');
    sb.append("sourceUrl");
    sb.append('=');
    sb.append(((this.sourceUrl == null) ? "<null>" : this.sourceUrl));
    sb.append(',');
    sb.append("openLicense");
    sb.append('=');
    sb.append(((this.openLicense == null) ? "<null>" : this.openLicense));
    sb.append(',');
    sb.append("image");
    sb.append('=');
    sb.append(((this.image == null) ? "<null>" : this.image));
    sb.append(',');
    sb.append("imageType");
    sb.append('=');
    sb.append(((this.imageType == null) ? "<null>" : this.imageType));
    sb.append(',');
    sb.append("summary");
    sb.append('=');
    sb.append(((this.summary == null) ? "<null>" : this.summary));
    sb.append(',');
    sb.append("cuisines");
    sb.append('=');
    sb.append(((this.cuisines == null) ? "<null>" : this.cuisines));
    sb.append(',');
    sb.append("dishTypes");
    sb.append('=');
    sb.append(((this.dishTypes == null) ? "<null>" : this.dishTypes));
    sb.append(',');
    sb.append("diets");
    sb.append('=');
    sb.append(((this.diets == null) ? "<null>" : this.diets));
    sb.append(',');
    sb.append("occasions");
    sb.append('=');
    sb.append(((this.occasions == null) ? "<null>" : this.occasions));
    sb.append(',');
    sb.append("instructions");
    sb.append('=');
    sb.append(((this.instructions == null) ? "<null>" : this.instructions));
    sb.append(',');
    sb.append("analyzedInstructions");
    sb.append('=');
    sb.append(((this.analyzedInstructions == null) ? "<null>" : this.analyzedInstructions));
    sb.append(',');
    sb.append("sourceName");
    sb.append('=');
    sb.append(((this.sourceName == null) ? "<null>" : this.sourceName));
    sb.append(',');
    sb.append("creditsText");
    sb.append('=');
    sb.append(((this.creditsText == null) ? "<null>" : this.creditsText));
    sb.append(',');
    sb.append("originalId");
    sb.append('=');
    sb.append(((this.originalId == null) ? "<null>" : this.originalId));
    sb.append(',');
    sb.append("additionalProperties");
    sb.append('=');
    sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.instructions == null) ? 0 : this.instructions.hashCode()));
    result = ((result * 31) + ((this.sustainable == null) ? 0 : this.sustainable.hashCode()));
    result =
        ((result * 31)
            + ((this.analyzedInstructions == null) ? 0 : this.analyzedInstructions.hashCode()));
    result = ((result * 31) + ((this.glutenFree == null) ? 0 : this.glutenFree.hashCode()));
    result = ((result * 31) + ((this.veryPopular == null) ? 0 : this.veryPopular.hashCode()));
    result = ((result * 31) + ((this.healthScore == null) ? 0 : this.healthScore.hashCode()));
    result = ((result * 31) + ((this.title == null) ? 0 : this.title.hashCode()));
    result = ((result * 31) + ((this.diets == null) ? 0 : this.diets.hashCode()));
    result = ((result * 31) + ((this.aggregateLikes == null) ? 0 : this.aggregateLikes.hashCode()));
    result = ((result * 31) + ((this.readyInMinutes == null) ? 0 : this.readyInMinutes.hashCode()));
    result = ((result * 31) + ((this.sourceUrl == null) ? 0 : this.sourceUrl.hashCode()));
    result = ((result * 31) + ((this.creditsText == null) ? 0 : this.creditsText.hashCode()));
    result = ((result * 31) + ((this.dairyFree == null) ? 0 : this.dairyFree.hashCode()));
    result = ((result * 31) + ((this.servings == null) ? 0 : this.servings.hashCode()));
    result = ((result * 31) + ((this.vegetarian == null) ? 0 : this.vegetarian.hashCode()));
    result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
    result =
        ((result * 31)
            + ((this.preparationMinutes == null) ? 0 : this.preparationMinutes.hashCode()));
    result = ((result * 31) + ((this.imageType == null) ? 0 : this.imageType.hashCode()));
    result = ((result * 31) + ((this.summary == null) ? 0 : this.summary.hashCode()));
    result = ((result * 31) + ((this.cookingMinutes == null) ? 0 : this.cookingMinutes.hashCode()));
    result = ((result * 31) + ((this.image == null) ? 0 : this.image.hashCode()));
    result = ((result * 31) + ((this.openLicense == null) ? 0 : this.openLicense.hashCode()));
    result = ((result * 31) + ((this.veryHealthy == null) ? 0 : this.veryHealthy.hashCode()));
    result = ((result * 31) + ((this.vegan == null) ? 0 : this.vegan.hashCode()));
    result = ((result * 31) + ((this.cheap == null) ? 0 : this.cheap.hashCode()));
    result =
        ((result * 31)
            + ((this.extendedIngredients == null) ? 0 : this.extendedIngredients.hashCode()));
    result = ((result * 31) + ((this.dishTypes == null) ? 0 : this.dishTypes.hashCode()));
    result = ((result * 31) + ((this.gaps == null) ? 0 : this.gaps.hashCode()));
    result = ((result * 31) + ((this.cuisines == null) ? 0 : this.cuisines.hashCode()));
    result = ((result * 31) + ((this.lowFodmap == null) ? 0 : this.lowFodmap.hashCode()));
    result =
        ((result * 31)
            + ((this.weightWatcherSmartPoints == null)
                ? 0
                : this.weightWatcherSmartPoints.hashCode()));
    result = ((result * 31) + ((this.occasions == null) ? 0 : this.occasions.hashCode()));
    result =
        ((result * 31) + ((this.pricePerServing == null) ? 0 : this.pricePerServing.hashCode()));
    result = ((result * 31) + ((this.sourceName == null) ? 0 : this.sourceName.hashCode()));
    result = ((result * 31) + ((this.originalId == null) ? 0 : this.originalId.hashCode()));
    result =
        ((result * 31)
            + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof ExtractedRecipeDTO) == false) {
      return false;
    }
    ExtractedRecipeDTO rhs = ((ExtractedRecipeDTO) other);
    return (((((((((((((((((((((((((((((((((((((this.instructions == rhs.instructions)
                                                                                                                                                    || ((this
                                                                                                                                                                .instructions
                                                                                                                                                            != null)
                                                                                                                                                        && this
                                                                                                                                                            .instructions
                                                                                                                                                            .equals(
                                                                                                                                                                rhs.instructions)))
                                                                                                                                                && ((this
                                                                                                                                                            .sustainable
                                                                                                                                                        == rhs.sustainable)
                                                                                                                                                    || ((this
                                                                                                                                                                .sustainable
                                                                                                                                                            != null)
                                                                                                                                                        && this
                                                                                                                                                            .sustainable
                                                                                                                                                            .equals(
                                                                                                                                                                rhs.sustainable))))
                                                                                                                                            && ((this
                                                                                                                                                        .analyzedInstructions
                                                                                                                                                    == rhs.analyzedInstructions)
                                                                                                                                                || ((this
                                                                                                                                                            .analyzedInstructions
                                                                                                                                                        != null)
                                                                                                                                                    && this
                                                                                                                                                        .analyzedInstructions
                                                                                                                                                        .equals(
                                                                                                                                                            rhs.analyzedInstructions))))
                                                                                                                                        && ((this
                                                                                                                                                    .glutenFree
                                                                                                                                                == rhs.glutenFree)
                                                                                                                                            || ((this
                                                                                                                                                        .glutenFree
                                                                                                                                                    != null)
                                                                                                                                                && this
                                                                                                                                                    .glutenFree
                                                                                                                                                    .equals(
                                                                                                                                                        rhs.glutenFree))))
                                                                                                                                    && ((this
                                                                                                                                                .veryPopular
                                                                                                                                            == rhs.veryPopular)
                                                                                                                                        || ((this
                                                                                                                                                    .veryPopular
                                                                                                                                                != null)
                                                                                                                                            && this
                                                                                                                                                .veryPopular
                                                                                                                                                .equals(
                                                                                                                                                    rhs.veryPopular))))
                                                                                                                                && ((this
                                                                                                                                            .healthScore
                                                                                                                                        == rhs.healthScore)
                                                                                                                                    || ((this
                                                                                                                                                .healthScore
                                                                                                                                            != null)
                                                                                                                                        && this
                                                                                                                                            .healthScore
                                                                                                                                            .equals(
                                                                                                                                                rhs.healthScore))))
                                                                                                                            && ((this
                                                                                                                                        .title
                                                                                                                                    == rhs.title)
                                                                                                                                || ((this
                                                                                                                                            .title
                                                                                                                                        != null)
                                                                                                                                    && this
                                                                                                                                        .title
                                                                                                                                        .equals(
                                                                                                                                            rhs.title))))
                                                                                                                        && ((this
                                                                                                                                    .diets
                                                                                                                                == rhs.diets)
                                                                                                                            || ((this
                                                                                                                                        .diets
                                                                                                                                    != null)
                                                                                                                                && this
                                                                                                                                    .diets
                                                                                                                                    .equals(
                                                                                                                                        rhs.diets))))
                                                                                                                    && ((this
                                                                                                                                .aggregateLikes
                                                                                                                            == rhs.aggregateLikes)
                                                                                                                        || ((this
                                                                                                                                    .aggregateLikes
                                                                                                                                != null)
                                                                                                                            && this
                                                                                                                                .aggregateLikes
                                                                                                                                .equals(
                                                                                                                                    rhs.aggregateLikes))))
                                                                                                                && ((this
                                                                                                                            .readyInMinutes
                                                                                                                        == rhs.readyInMinutes)
                                                                                                                    || ((this
                                                                                                                                .readyInMinutes
                                                                                                                            != null)
                                                                                                                        && this
                                                                                                                            .readyInMinutes
                                                                                                                            .equals(
                                                                                                                                rhs.readyInMinutes))))
                                                                                                            && ((this
                                                                                                                        .sourceUrl
                                                                                                                    == rhs.sourceUrl)
                                                                                                                || ((this
                                                                                                                            .sourceUrl
                                                                                                                        != null)
                                                                                                                    && this
                                                                                                                        .sourceUrl
                                                                                                                        .equals(
                                                                                                                            rhs.sourceUrl))))
                                                                                                        && ((this
                                                                                                                    .creditsText
                                                                                                                == rhs.creditsText)
                                                                                                            || ((this
                                                                                                                        .creditsText
                                                                                                                    != null)
                                                                                                                && this
                                                                                                                    .creditsText
                                                                                                                    .equals(
                                                                                                                        rhs.creditsText))))
                                                                                                    && ((this
                                                                                                                .dairyFree
                                                                                                            == rhs.dairyFree)
                                                                                                        || ((this
                                                                                                                    .dairyFree
                                                                                                                != null)
                                                                                                            && this
                                                                                                                .dairyFree
                                                                                                                .equals(
                                                                                                                    rhs.dairyFree))))
                                                                                                && ((this
                                                                                                            .servings
                                                                                                        == rhs.servings)
                                                                                                    || ((this
                                                                                                                .servings
                                                                                                            != null)
                                                                                                        && this
                                                                                                            .servings
                                                                                                            .equals(
                                                                                                                rhs.servings))))
                                                                                            && ((this
                                                                                                        .vegetarian
                                                                                                    == rhs.vegetarian)
                                                                                                || ((this
                                                                                                            .vegetarian
                                                                                                        != null)
                                                                                                    && this
                                                                                                        .vegetarian
                                                                                                        .equals(
                                                                                                            rhs.vegetarian))))
                                                                                        && ((this.id
                                                                                                == rhs.id)
                                                                                            || ((this
                                                                                                        .id
                                                                                                    != null)
                                                                                                && this
                                                                                                    .id
                                                                                                    .equals(
                                                                                                        rhs.id))))
                                                                                    && ((this
                                                                                                .preparationMinutes
                                                                                            == rhs.preparationMinutes)
                                                                                        || ((this
                                                                                                    .preparationMinutes
                                                                                                != null)
                                                                                            && this
                                                                                                .preparationMinutes
                                                                                                .equals(
                                                                                                    rhs.preparationMinutes))))
                                                                                && ((this.imageType
                                                                                        == rhs.imageType)
                                                                                    || ((this
                                                                                                .imageType
                                                                                            != null)
                                                                                        && this
                                                                                            .imageType
                                                                                            .equals(
                                                                                                rhs.imageType))))
                                                                            && ((this.summary
                                                                                    == rhs.summary)
                                                                                || ((this.summary
                                                                                        != null)
                                                                                    && this.summary
                                                                                        .equals(
                                                                                            rhs.summary))))
                                                                        && ((this.cookingMinutes
                                                                                == rhs.cookingMinutes)
                                                                            || ((this.cookingMinutes
                                                                                    != null)
                                                                                && this
                                                                                    .cookingMinutes
                                                                                    .equals(
                                                                                        rhs.cookingMinutes))))
                                                                    && ((this.image == rhs.image)
                                                                        || ((this.image != null)
                                                                            && this.image.equals(
                                                                                rhs.image))))
                                                                && ((this.openLicense
                                                                        == rhs.openLicense)
                                                                    || ((this.openLicense != null)
                                                                        && this.openLicense.equals(
                                                                            rhs.openLicense))))
                                                            && ((this.veryHealthy
                                                                    == rhs.veryHealthy)
                                                                || ((this.veryHealthy != null)
                                                                    && this.veryHealthy.equals(
                                                                        rhs.veryHealthy))))
                                                        && ((this.vegan == rhs.vegan)
                                                            || ((this.vegan != null)
                                                                && this.vegan.equals(rhs.vegan))))
                                                    && ((this.cheap == rhs.cheap)
                                                        || ((this.cheap != null)
                                                            && this.cheap.equals(rhs.cheap))))
                                                && ((this.extendedIngredients
                                                        == rhs.extendedIngredients)
                                                    || ((this.extendedIngredients != null)
                                                        && this.extendedIngredients.equals(
                                                            rhs.extendedIngredients))))
                                            && ((this.dishTypes == rhs.dishTypes)
                                                || ((this.dishTypes != null)
                                                    && this.dishTypes.equals(rhs.dishTypes))))
                                        && ((this.gaps == rhs.gaps)
                                            || ((this.gaps != null) && this.gaps.equals(rhs.gaps))))
                                    && ((this.cuisines == rhs.cuisines)
                                        || ((this.cuisines != null)
                                            && this.cuisines.equals(rhs.cuisines))))
                                && ((this.lowFodmap == rhs.lowFodmap)
                                    || ((this.lowFodmap != null)
                                        && this.lowFodmap.equals(rhs.lowFodmap))))
                            && ((this.weightWatcherSmartPoints == rhs.weightWatcherSmartPoints)
                                || ((this.weightWatcherSmartPoints != null)
                                    && this.weightWatcherSmartPoints.equals(
                                        rhs.weightWatcherSmartPoints))))
                        && ((this.occasions == rhs.occasions)
                            || ((this.occasions != null) && this.occasions.equals(rhs.occasions))))
                    && ((this.pricePerServing == rhs.pricePerServing)
                        || ((this.pricePerServing != null)
                            && this.pricePerServing.equals(rhs.pricePerServing))))
                && ((this.sourceName == rhs.sourceName)
                    || ((this.sourceName != null) && this.sourceName.equals(rhs.sourceName))))
            && ((this.originalId == rhs.originalId)
                || ((this.originalId != null) && this.originalId.equals(rhs.originalId))))
        && ((this.additionalProperties == rhs.additionalProperties)
            || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
  }
}
