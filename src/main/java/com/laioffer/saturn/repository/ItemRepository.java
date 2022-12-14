package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.Status;
import com.laioffer.saturn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    //List<Item> findItemByName(String name);

    List<Item> findItemByUsername(String username);

    List<Item> findItemByUsernameAndStatus(String username, Status status);

    Item findItemByIdAndUsername(Long id, String username);

    Item findItemById(Long id);

    Item findItemByAsks(Long askId);
    //added below
    //List<Item> findItemsById(Long ids);

   List<Item> findItemByNameContaining(String name);

    // find the item by the item's id and user (buyer)
    //Item findByIdAndUser(Long id, User user);

    // Item findById(Long id, User user);

    //Item findItembyId(Long id);

    //List<Item> findItemByNameContainsOrderById(String name);

    //List<Item> findItemById(List<Long> ids);

}
