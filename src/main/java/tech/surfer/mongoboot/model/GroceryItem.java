package tech.surfer.mongoboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
@Getter
@Setter
@ToString
public class GroceryItem {

    @Id
    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private int quantity;

    private String category;

    public GroceryItem(@NonNull String id, @NonNull String name, @NonNull int quantity, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
