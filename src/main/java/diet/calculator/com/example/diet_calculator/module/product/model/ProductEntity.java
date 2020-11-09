package diet.calculator.com.example.diet_calculator.module.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double proteinAmount;
    private double fatAmount;
    private double carbAmount;

    public double calculateCalories() {
        return proteinAmount * Macronutrients.PROTEIN.getCalories() +
                fatAmount * Macronutrients.FAT.getCalories() + carbAmount * Macronutrients.CARBOHYDRATES.getCalories();
    }


}