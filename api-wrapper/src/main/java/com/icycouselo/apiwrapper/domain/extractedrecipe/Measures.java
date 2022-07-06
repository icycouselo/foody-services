package com.icycouselo.apiwrapper.domain.extractedrecipe;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"us", "metric"})
@Generated("jsonschema2pojo")
public class Measures {

  @JsonProperty("us")
  private Us us;

  @JsonProperty("metric")
  private Metric metric;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("us")
  public Us getUs() {
    return us;
  }

  @JsonProperty("us")
  public void setUs(Us us) {
    this.us = us;
  }

  public Measures withUs(Us us) {
    this.us = us;
    return this;
  }

  @JsonProperty("metric")
  public Metric getMetric() {
    return metric;
  }

  @JsonProperty("metric")
  public void setMetric(Metric metric) {
    this.metric = metric;
  }

  public Measures withMetric(Metric metric) {
    this.metric = metric;
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

  public Measures withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Measures.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("us");
    sb.append('=');
    sb.append(((this.us == null) ? "<null>" : this.us));
    sb.append(',');
    sb.append("metric");
    sb.append('=');
    sb.append(((this.metric == null) ? "<null>" : this.metric));
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
    result =
        ((result * 31)
            + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
    result = ((result * 31) + ((this.metric == null) ? 0 : this.metric.hashCode()));
    result = ((result * 31) + ((this.us == null) ? 0 : this.us.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof Measures) == false) {
      return false;
    }
    Measures rhs = ((Measures) other);
    return ((((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null)
                    && this.additionalProperties.equals(rhs.additionalProperties)))
            && ((this.metric == rhs.metric)
                || ((this.metric != null) && this.metric.equals(rhs.metric))))
        && ((this.us == rhs.us) || ((this.us != null) && this.us.equals(rhs.us))));
  }
}
