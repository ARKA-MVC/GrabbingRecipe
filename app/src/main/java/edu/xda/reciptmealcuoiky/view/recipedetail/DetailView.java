package edu.xda.reciptmealcuoiky.view.recipedetail;

import java.util.List;

import edu.xda.reciptmealcuoiky.model.Meals;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeal(Meals.Meal meal);
    void onErrorLoading(String err);
    void searchMeal(List<Meals.Meal> meals);
}
