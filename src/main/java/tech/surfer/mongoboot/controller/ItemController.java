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

    @GetMapping("/category/{category}")
    public List<GroceryItem> getAllItemsInCategory(@PathVariable(value = "category") String category) {
        return itemRepository.findAll(category);
    }

    @GetMapping("/{id}")
    public GroceryItem getAllItemById(@PathVariable(value = "id") String id) throws RuntimeException {
        return itemRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @GetMapping("/count")
    public long getGroceryItemCount() {
        return itemRepository.count();
    }

    @PutMapping("/category/{category}")
    public long updateCategory(@PathVariable(value = "category") String category,
                                    @RequestParam(value = "newCategory") String newCategory) {
        log.info("newCategory {}", newCategory);

        // Find all the items with the category snacks
        List<GroceryItem> list = itemRepository.findAll(category);

        list.forEach(item -> {
            // Update the category in each document
            item.setCategory(newCategory);
        });

        // Save all the items in database
        List<GroceryItem> itemsUpdated = itemRepository.saveAll(list);

        log.info("Successfully updated " + itemsUpdated.size() + " items.");

        return itemsUpdated.size();
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable(value = "id") String id) {
        itemRepository.deleteById(id);
        log.info("Item deleted with id : {}", id);
    }
}
