package pl.wszib.pizzamarket.services;

import org.springframework.stereotype.Service;
import pl.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.wszib.pizzamarket.data.repositiories.PizzaRepository;
import pl.wszib.pizzamarket.web.mappers.PizzaMapper;
import pl.wszib.pizzamarket.web.models.PizzaModel;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaModel> findAll() {
        List<PizzaEntity> entities = pizzaRepository.findAll();
        return entities.stream()
                .map(PizzaMapper::toModel)
                .toList();
    }
}
