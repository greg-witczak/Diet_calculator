package diet.calculator.com.example.diet_calculator.module.product.service;

import diet.calculator.com.example.diet_calculator.module.mapper.ProductMapper;
import diet.calculator.com.example.diet_calculator.module.product.model.dto.ProductDto;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;
import diet.calculator.com.example.diet_calculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;


    public void getOne(Long productId) {
        productRepository.getOne(productId);
    }


    public void updateProduct(Long productId, ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.maptoEntity(productDto);
        productEntity.setId(productId);
        productRepository.save(productEntity);

    }

    public List<ProductDto> getProducts() {
        List<ProductEntity> allProducts = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductEntity product : allProducts) {
            ProductDto productDto = ProductMapper.maptoDTO(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }


    public void saveProductDTO(ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.maptoEntity(productDto);
        productRepository.save(productEntity);
    }



    @PostConstruct
    public void  productsAdd(){
        ProductDto productDto = new ProductDto();
        productDto.setName("Bannan");
        productDto.setCarbAmount(11);
        productDto.setFatAmount(1);
        productDto.setProteinAmount(22);
        saveProductDTO(productDto);


        FoodNutritionService foodNutritionService = new FoodNutritionService();
        foodNutritionService.downloadFoodByIdAndSaveProductToDb(39790L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(32L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(315L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(1L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(23L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(397L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(90L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(970L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(7910L);
//        foodNutritionService.downloadFoodByIdAndSaveProductToDb(12345L);
    }
    public void saveProductEntity(FoodNutritionService foodNutritionService){


//        productRepository.save(productEntity);
    }
    // TODO zbudowac na tej podstawie ProductEntity (new ProductEntity()    .setName(..)
    // TODO zapisac ProductEntity do bazy (używając ProductRepository) save
}
