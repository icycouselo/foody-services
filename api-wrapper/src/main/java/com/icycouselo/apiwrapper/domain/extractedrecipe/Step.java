package com.icycouselo.apiwrapper.domain.extractedrecipe;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"number", "step", "ingredients", "equipment", "length"})
@Generated("jsonschema2pojo")
public class Step {

  @JsonProperty("number")
  private Integer number;

  @JsonProperty("step")
  private String step;

  @JsonProperty("ingredients")
  private List<Ingredient> ingredients = null;

  @JsonProperty("equipment")
  private List<Equipment> equipment = null;

  @JsonProperty("length")
  private Length length;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("number")
  public Integer getNumber() {
    return number;
  }

  @JsonProperty("number")
  public void setNumber(Integer number) {
    this.number = number;
  }

  public Step withNumber(Integer number) {
    this.number = number;
    return this;
  }

  @JsonProperty("step")
  public String getStep() {
    return step;
  }

  @JsonProperty("step")
  public void setStep(String step) {
    this.step = step;
  }

  public Step withStep(String step) {
    this.step = step;
    return this;
  }

  @JsonProperty("ingredients")
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  @JsonProperty("ingredients")
  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public Step withIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
    return this;
  }

  @JsonProperty("equipment")
  public List<Equipment> getEquipment() {
    return equipment;
  }

  @JsonProperty("equipment")
  public void setEquipment(List<Equipment> equipment) {
    this.equipment = equipment;
  }

  public Step withEquipment(List<Equipment> equipment) {
    this.equipment = equipment;
    return this;
  }

  @JsonProperty("length")
  public Length getLength() {
    return length;
  }

  @JsonProperty("length")
  public void setLength(Length length) {
    this.length = length;
  }

  public Step withLength(Length length) {
    this.length = length;
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

  public Step withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Step.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("number");
    sb.append('=');
    sb.append(((this.number == null) ? "<null>" : this.number));
    sb.append(',');
    sb.append("step");
    sb.append('=');
    sb.append(((this.step == null) ? "<null>" : this.step));
    sb.append(',');
    sb.append("ingredients");
    sb.append('=');
    sb.append(((this.ingredients == null) ? "<null>" : this.ingredients));
    sb.append(',');
    sb.append("equipment");
    sb.append('=');
    sb.append(((this.equipment == null) ? "<null>" : this.equipment));
    sb.append(',');
    sb.append("length");
    sb.append('=');
    sb.append(((this.length == null) ? "<null>" : this.length));
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
    result = ((result * 31) + ((this.number == null) ? 0 : this.number.hashCode()));
    result = ((result * 31) + ((this.length == null) ? 0 : this.length.hashCode()));
    result = ((result * 31) + ((this.ingredients == null) ? 0 : this.ingredients.hashCode()));
    result = ((result * 31) + ((this.equipment == null) ? 0 : this.equipment.hashCode()));
    result = ((result * 31) + ((this.step == null) ? 0 : this.step.hashCode()));
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
    if ((other instanceof Step) == false) {
      return false;
    }
    Step rhs = ((Step) other);
    return (((((((this.number == rhs.number)
                            || ((this.number != null) && this.number.equals(rhs.number)))
                        && ((this.length == rhs.length)
                            || ((this.length != null) && this.length.equals(rhs.length))))
                    && ((this.ingredients == rhs.ingredients)
                        || ((this.ingredients != null)
                            && this.ingredients.equals(rhs.ingredients))))
                && ((this.equipment == rhs.equipment)
                    || ((this.equipment != null) && this.equipment.equals(rhs.equipment))))
            && ((this.step == rhs.step) || ((this.step != null) && this.step.equals(rhs.step))))
        && ((this.additionalProperties == rhs.additionalProperties)
            || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
  }
}
