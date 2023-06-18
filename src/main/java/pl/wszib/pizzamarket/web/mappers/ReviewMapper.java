package pl.wszib.pizzamarket.web.mappers;

import pl.wszib.pizzamarket.data.entities.ReviewEntity;
import pl.wszib.pizzamarket.web.models.ReviewModel;

public class ReviewMapper {

    public static ReviewModel toModel(ReviewEntity entity) {
        return new ReviewModel(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getReview()
        );
    }

    public static ReviewEntity toEntity(ReviewModel model) {
        ReviewEntity entity = new ReviewEntity();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setReview(model.getReview());
        return entity;
    }
}
