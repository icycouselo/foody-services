package com.icycouselo.apiwrapper.entity.extractedrecipe;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "localizedName", "image"})
@Generated("jsonschema2pojo")
public class Ingredient {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("localizedName")
    private String localizedName;

    @JsonProperty("image")
    private String image;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Ingredient withId(Integer id) {
        this.id = id;
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

    public Ingredient withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("localizedName")
    public String getLocalizedName() {
        return localizedName;
    }

    @JsonProperty("localizedName")
    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public Ingredient withLocalizedName(String localizedName) {
        this.localizedName = localizedName;
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

    public Ingredient withImage(String image) {
        this.image = image;
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

    public Ingredient withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Ingredient.class.getName())
                .append('@')
                .append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("localizedName");
        sb.append('=');
        sb.append(((this.localizedName == null) ? "<null>" : this.localizedName));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null) ? "<null>" : this.image));
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
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.image == null) ? 0 : this.image.hashCode()));
        result = ((result * 31) + ((this.localizedName == null) ? 0 : this.localizedName.hashCode()));
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
        if ((other instanceof Ingredient) == false) {
            return false;
        }
        Ingredient rhs = ((Ingredient) other);
        return ((((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.image == rhs.image)
                || ((this.image != null) && this.image.equals(rhs.image))))
                && ((this.localizedName == rhs.localizedName)
                || ((this.localizedName != null)
                && this.localizedName.equals(rhs.localizedName))))
                && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
                && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null)
                && this.additionalProperties.equals(rhs.additionalProperties))));
    }
}
