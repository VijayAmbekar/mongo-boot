package tech.surfer.mongoboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
@RequiredArgsConstructor
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

    @NonNull
    private String category;

}
