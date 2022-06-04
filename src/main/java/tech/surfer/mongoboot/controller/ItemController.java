package tech.surfer.mongoboot.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tech.surfer.mongoboot.dao.ItemRepository;
import tech.surfer.mongoboot.model.GroceryItem;

import java.util.List;

@RestController
@RequestMapping("/items")
@Slf4j
@RequiredArgsConstructor
public class ItemController {

    @NonNull
    private ItemRepository itemRepository;

    @PostMapping(value = "")
    public GroceryItem addItem(@RequestBody GroceryItem groceryItem) {
        itemRepository.save(groceryItem);
        return groceryItem;
    }

    @GetMapping
    public List<GroceryItem> getAllItems() {
        return itemRepository.findAll();
    }

    //TODO: fix this currently not working
   /* @GetMapping("/category/{category}")
    public List<GroceryItem> getAllItemsInCategory(@PathVariable(value = "category") String category) {
        return itemRepository.findAll(category);
    }*/

    @GetMapping("/{id}")
    public GroceryItem getAllItemById(@PathVariable(value = "id") String id) throws Exception{
        return itemRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
