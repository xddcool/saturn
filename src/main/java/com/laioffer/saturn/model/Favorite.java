package com.laioffer.saturn.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "favorite")
@JsonDeserialize(builder = Favorite.Builder.class)
public class Favorite implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


//    @JsonProperty("item_id")
//    //@Column(name = "itemId")
//    private Long itemId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    //    public Long getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(Long itemId) {
//        this.itemId = itemId;
//    }

    public Favorite() {}

    public Favorite(Builder builder) {
        this.username = builder.username;
        this.item = builder.item;
        //this.itemId = builder.itemId;
    }

    public static class Builder {
        @JsonProperty("username")
        private String username;

//        @JsonProperty("item_id")
//        private Long itemId;
        private Item item;

        public Builder setItem(Item item) {
            this.item = item;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

//        public Builder setItemId(Long itemId) {
//            this.itemId = itemId;
//            return this;
//        }

        public Favorite build() {
            return new Favorite(this);
        }
    }
}