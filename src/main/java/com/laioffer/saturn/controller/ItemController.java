package com.laioffer.saturn.controller;


import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.User;
import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.security.Principal;
import java.util.List;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //Item delete mapping
    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable Long itemId, Principal principal) {
        itemService.delete(itemId, principal);
    }

    //Item add mapping

    @PostMapping("/items")
    public void addItem(
            @RequestParam("itemName") String name,
            @RequestParam("itemDesc") String description,
            @RequestParam("itemPrice") Double price,
            @RequestParam("itemImages") MultipartFile[] images,
            Principal principal) {

        Item item = new Item.Builder().setName(name)
                .setDescription(description)
                .setPrice(price)
                .setUsername(principal.getName())
                .build();
        itemService.add(item, images);
    }

    //Item get mapping
    @GetMapping(value = "/items")
    public List<Item> listItems(Principal principal) {
        return itemService.get(principal);
    }

    //Item edit mapping
    @PutMapping(value = "/items/{itemId}")
    public void editItem(
            @PathVariable Long itemId,
            @RequestBody Item item,
            Principal principal){

        itemService.edit(item, itemId, principal);
    }

}
