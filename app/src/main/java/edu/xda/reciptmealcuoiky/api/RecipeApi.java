package edu.xda.reciptmealcuoiky.api;

import edu.xda.reciptmealcuoiky.model.Categories;
import edu.xda.reciptmealcuoiky.model.Meals;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
    @GET("categories.php")
    Call<Categories> getCategories();

    @GET("filter.php")
    Call<Meals> getMealByCat(@Query("c") String category);

    @GET("search.php")
    Call<Meals> getMealByName(@Query("s") String meal);

    @GET("search.php")
    Call<Meals> getMealByFirstLetter(@Query("f") String meal);
}
