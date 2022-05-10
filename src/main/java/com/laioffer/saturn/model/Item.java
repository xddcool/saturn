package com.laioffer.saturn.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "item")
@JsonDeserialize(builder = Item.Builder.class)

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @JoinColumn
    private String username;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<ItemImage> images;

    public Item() {}

    private Item(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.images = builder.images;

    }
    public Long getId() {return id;}

    public void setId(Long id) {this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ItemImage> getImages() {
        return images;
    }

    public Item setImages(List<ItemImage> images) {
        this.images = images;
        return this;
    }

    public static class Builder {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("description")
        private String description;

        @JsonProperty("price")
        private Double price;

        @JsonProperty("images")
        private List<ItemImage> images;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder setImages(List<ItemImage> images) {
            this.images = images;
            return this;
        }

        public Item build() {return new Item(this);}
    }
}
