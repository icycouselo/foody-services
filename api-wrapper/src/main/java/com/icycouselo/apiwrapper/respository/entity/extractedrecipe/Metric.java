package com.icycouselo.apiwrapper.respository.entity.extractedrecipe;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"amount", "unitShort", "unitLong"})
@Generated("jsonschema2pojo")
public class Metric {

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("unitShort")
  private String unitShort;

  @JsonProperty("unitLong")
  private String unitLong;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  @JsonProperty("amount")
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Metric withAmount(Double amount) {
    this.amount = amount;
    return this;
  }

  @JsonProperty("unitShort")
  public String getUnitShort() {
    return unitShort;
  }

  @JsonProperty("unitShort")
  public void setUnitShort(String unitShort) {
    this.unitShort = unitShort;
  }

  public Metric withUnitShort(String unitShort) {
    this.unitShort = unitShort;
    return this;
  }

  @JsonProperty("unitLong")
  public String getUnitLong() {
    return unitLong;
  }

  @JsonProperty("unitLong")
  public void setUnitLong(String unitLong) {
    this.unitLong = unitLong;
  }

  public Metric withUnitLong(String unitLong) {
    this.unitLong = unitLong;
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

  public Metric withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Metric.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("amount");
    sb.append('=');
    sb.append(((this.amount == null) ? "<null>" : this.amount));
    sb.append(',');
    sb.append("unitShort");
    sb.append('=');
    sb.append(((this.unitShort == null) ? "<null>" : this.unitShort));
    sb.append(',');
    sb.append("unitLong");
    sb.append('=');
    sb.append(((this.unitLong == null) ? "<null>" : this.unitLong));
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
    result = ((result * 31) + ((this.amount == null) ? 0 : this.amount.hashCode()));
    result = ((result * 31) + ((this.unitLong == null) ? 0 : this.unitLong.hashCode()));
    result = ((result * 31) + ((this.unitShort == null) ? 0 : this.unitShort.hashCode()));
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
    if ((other instanceof Metric) == false) {
      return false;
    }
    Metric rhs = ((Metric) other);
    return (((((this.amount == rhs.amount)
                    || ((this.amount != null) && this.amount.equals(rhs.amount)))
                && ((this.unitLong == rhs.unitLong)
                    || ((this.unitLong != null) && this.unitLong.equals(rhs.unitLong))))
            && ((this.unitShort == rhs.unitShort)
                || ((this.unitShort != null) && this.unitShort.equals(rhs.unitShort))))
        && ((this.additionalProperties == rhs.additionalProperties)
            || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
  }
}
