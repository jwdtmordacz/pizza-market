package pl.wszib.pizzamarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.pizzamarket.services.ReviewService;
import pl.wszib.pizzamarket.web.models.ReviewModel;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("opinie")
    public String reviewPage(Model model) {
        List<ReviewModel> reviews = reviewService.findAll();
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new ReviewModel());
        return "reviewPage";
    }

    @PostMapping("opinie")
    public String saveReview(@ModelAttribute("review") ReviewModel reviewModel) {
        reviewService.saveReview(reviewModel);
        return "redirect:/opinie";
    }
}
