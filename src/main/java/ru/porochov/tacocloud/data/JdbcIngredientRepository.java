package ru.porochov.tacocloud.data;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.porochov.tacocloud.model.Ingredient;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ingredient> findAll() {
        return jdbcTemplate.query("SELECT id, name, type from Ingredient",
                new BeanPropertyRowMapper<>(Ingredient.class));
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return Optional.of(jdbcTemplate.queryForObject("SELECT id, name, type from Ingredient where id = ?",
                new BeanPropertyRowMapper<>(Ingredient.class), id));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
