package edu.xda.reciptmealcuoiky.view.main;

import java.util.List;

import edu.xda.reciptmealcuoiky.model.Categories;

public interface MainView {

    /*
    The interface of this method will behave bridging between presenters to activities then activity Overriding the interface

    1. behavior, when loading must appear || showLoading();
    * 2. Loading must be removed || hideLoading()
    • 3. Display Meal data (with List <Meal> meals) parameters || setMeals (0;
    * 4. Displays Category data (with List parameters <Category> category) setCategories ( );
    * 5. and, Behavior when an error occurs when requesting data to the API
    *  */
    void showLoading();
    void hideLoading();
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);

}
