package edu.xda.reciptmealcuoiky.view.recipedetail;

import edu.xda.reciptmealcuoiky.Utils;
import edu.xda.reciptmealcuoiky.model.Meals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    public void getMealById(String meal){
        view.showLoading();
        Utils.getApi().getMealByName(meal).enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                view.hideLoading();
                if(response.isSuccessful() && response.body() != null){
                    view.setMeal(response.body().getMeals().get(0));
                }else{
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }

    void getByName(String letter){
        view.showLoading();
        Utils.getApi().getMealByFirstLetter(letter).enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                view.hideLoading();
                if(response.isSuccessful() && response.body() != null){
                    view.searchMeal(response.body().getMeals());
                }else{
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
