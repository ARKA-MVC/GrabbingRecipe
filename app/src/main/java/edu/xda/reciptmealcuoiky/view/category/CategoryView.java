package edu.xda.reciptmealcuoiky.view.category;

import java.util.List;

import edu.xda.reciptmealcuoiky.model.Meals;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setMeals(List<Meals.Meal> meals);
    void onErrorLoading(String message);
}
