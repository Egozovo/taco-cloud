package ru.porochov.tacocloud.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.porochov.tacocloud.data.IngredientRepository;
import ru.porochov.tacocloud.model.Ingredient;
import ru.porochov.tacocloud.model.Ingredient.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
