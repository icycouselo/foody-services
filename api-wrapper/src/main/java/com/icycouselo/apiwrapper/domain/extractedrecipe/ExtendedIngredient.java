package com.icycouselo.apiwrapper.domain.extractedrecipe;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "id",
  "aisle",
  "image",
  "consistency",
  "name",
  "nameClean",
  "original",
  "originalName",
  "amount",
  "unit",
  "meta",
  "measures"
})
@Generated("jsonschema2pojo")
public class ExtendedIngredient {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("aisle")
  private String aisle;

  @JsonProperty("image")
  private String image;

  @JsonProperty("consistency")
  private String consistency;

  @JsonProperty("name")
  private String name;

  @JsonProperty("nameClean")
  private String nameClean;

  @JsonProperty("original")
  private String original;

  @JsonProperty("originalName")
  private String originalName;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("unit")
  private String unit;

  @JsonProperty("meta")
  private List<String> meta = null;

  @JsonProperty("measures")
  private Measures measures;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  public ExtendedIngredient withId(Integer id) {
    this.id = id;
    return this;
  }

  @JsonProperty("aisle")
  public String getAisle() {
    return aisle;
  }

  @JsonProperty("aisle")
  public void setAisle(String aisle) {
    this.aisle = aisle;
  }

  public ExtendedIngredient withAisle(String aisle) {
    this.aisle = aisle;
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

  public ExtendedIngredient withImage(String image) {
    this.image = image;
    return this;
  }

  @JsonProperty("consistency")
  public String getConsistency() {
    return consistency;
  }

  @JsonProperty("consistency")
  public void setConsistency(String consistency) {
    this.consistency = consistency;
  }

  public ExtendedIngredient withConsistency(String consistency) {
    this.consistency = consistency;
    return this;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  public ExtendedIngredient withName(String name) {
    this.name = name;
    return this;
  }

  @JsonProperty("nameClean")
  public String getNameClean() {
    return nameClean;
  }

  @JsonProperty("nameClean")
  public void setNameClean(String nameClean) {
    this.nameClean = nameClean;
  }

  public ExtendedIngredient withNameClean(String nameClean) {
    this.nameClean = nameClean;
    return this;
  }

  @JsonProperty("original")
  public String getOriginal() {
    return original;
  }

  @JsonProperty("original")
  public void setOriginal(String original) {
    this.original = original;
  }

  public ExtendedIngredient withOriginal(String original) {
    this.original = original;
    return this;
  }

  @JsonProperty("originalName")
  public String getOriginalName() {
    return originalName;
  }

  @JsonProperty("originalName")
  public void setOriginalName(String originalName) {
    this.originalName = originalName;
  }

  public ExtendedIngredient withOriginalName(String originalName) {
    this.originalName = originalName;
    return this;
  }

  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  @JsonProperty("amount")
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public ExtendedIngredient withAmount(Double amount) {
    this.amount = amount;
    return this;
  }

  @JsonProperty("unit")
  public String getUnit() {
    return unit;
  }

  @JsonProperty("unit")
  public void setUnit(String unit) {
    this.unit = unit;
  }

  public ExtendedIngredient withUnit(String unit) {
    this.unit = unit;
    return this;
  }

  @JsonProperty("meta")
  public List<String> getMeta() {
    return meta;
  }

  @JsonProperty("meta")
  public void setMeta(List<String> meta) {
    this.meta = meta;
  }

  public ExtendedIngredient withMeta(List<String> meta) {
    this.meta = meta;
    return this;
  }

  @JsonProperty("measures")
  public Measures getMeasures() {
    return measures;
  }

  @JsonProperty("measures")
  public void setMeasures(Measures measures) {
    this.measures = measures;
  }

  public ExtendedIngredient withMeasures(Measures measures) {
    this.measures = measures;
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

  public ExtendedIngredient withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(ExtendedIngredient.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("id");
    sb.append('=');
    sb.append(((this.id == null) ? "<null>" : this.id));
    sb.append(',');
    sb.append("aisle");
    sb.append('=');
    sb.append(((this.aisle == null) ? "<null>" : this.aisle));
    sb.append(',');
    sb.append("image");
    sb.append('=');
    sb.append(((this.image == null) ? "<null>" : this.image));
    sb.append(',');
    sb.append("consistency");
    sb.append('=');
    sb.append(((this.consistency == null) ? "<null>" : this.consistency));
    sb.append(',');
    sb.append("name");
    sb.append('=');
    sb.append(((this.name == null) ? "<null>" : this.name));
    sb.append(',');
    sb.append("nameClean");
    sb.append('=');
    sb.append(((this.nameClean == null) ? "<null>" : this.nameClean));
    sb.append(',');
    sb.append("original");
    sb.append('=');
    sb.append(((this.original == null) ? "<null>" : this.original));
    sb.append(',');
    sb.append("originalName");
    sb.append('=');
    sb.append(((this.originalName == null) ? "<null>" : this.originalName));
    sb.append(',');
    sb.append("amount");
    sb.append('=');
    sb.append(((this.amount == null) ? "<null>" : this.amount));
    sb.append(',');
    sb.append("unit");
    sb.append('=');
    sb.append(((this.unit == null) ? "<null>" : this.unit));
    sb.append(',');
    sb.append("meta");
    sb.append('=');
    sb.append(((this.meta == null) ? "<null>" : this.meta));
    sb.append(',');
    sb.append("measures");
    sb.append('=');
    sb.append(((this.measures == null) ? "<null>" : this.measures));
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
    result = ((result * 31) + ((this.image == null) ? 0 : this.image.hashCode()));
    result = ((result * 31) + ((this.amount == null) ? 0 : this.amount.hashCode()));
    result = ((result * 31) + ((this.nameClean == null) ? 0 : this.nameClean.hashCode()));
    result = ((result * 31) + ((this.original == null) ? 0 : this.original.hashCode()));
    result = ((result * 31) + ((this.aisle == null) ? 0 : this.aisle.hashCode()));
    result = ((result * 31) + ((this.consistency == null) ? 0 : this.consistency.hashCode()));
    result = ((result * 31) + ((this.originalName == null) ? 0 : this.originalName.hashCode()));
    result = ((result * 31) + ((this.unit == null) ? 0 : this.unit.hashCode()));
    result = ((result * 31) + ((this.measures == null) ? 0 : this.measures.hashCode()));
    result = ((result * 31) + ((this.meta == null) ? 0 : this.meta.hashCode()));
    result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
    result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
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
    if ((other instanceof ExtendedIngredient) == false) {
      return false;
    }
    ExtendedIngredient rhs = ((ExtendedIngredient) other);
    return ((((((((((((((this.image == rhs.image)
                                                        || ((this.image != null)
                                                            && this.image.equals(rhs.image)))
                                                    && ((this.amount == rhs.amount)
                                                        || ((this.amount != null)
                                                            && this.amount.equals(rhs.amount))))
                                                && ((this.nameClean == rhs.nameClean)
                                                    || ((this.nameClean != null)
                                                        && this.nameClean.equals(rhs.nameClean))))
                                            && ((this.original == rhs.original)
                                                || ((this.original != null)
                                                    && this.original.equals(rhs.original))))
                                        && ((this.aisle == rhs.aisle)
                                            || ((this.aisle != null)
                                                && this.aisle.equals(rhs.aisle))))
                                    && ((this.consistency == rhs.consistency)
                                        || ((this.consistency != null)
                                            && this.consistency.equals(rhs.consistency))))
                                && ((this.originalName == rhs.originalName)
                                    || ((this.originalName != null)
                                        && this.originalName.equals(rhs.originalName))))
                            && ((this.unit == rhs.unit)
                                || ((this.unit != null) && this.unit.equals(rhs.unit))))
                        && ((this.measures == rhs.measures)
                            || ((this.measures != null) && this.measures.equals(rhs.measures))))
                    && ((this.meta == rhs.meta)
                        || ((this.meta != null) && this.meta.equals(rhs.meta))))
                && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
            && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
        && ((this.additionalProperties == rhs.additionalProperties)
            || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
  }
}
