package edu.xda.reciptmealcuoiky.view.main;

import androidx.annotation.NonNull;

import edu.xda.reciptmealcuoiky.Utils;
import edu.xda.reciptmealcuoiky.model.Categories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    void getCategories(){
        //thực hiện loading trước khi gọi request đến server
         view.showLoading();
         Call<Categories> categoriesCall = Utils.getApi().getCategories();
         categoriesCall.enqueue(new Callback<Categories>() {
             @Override
             public void onResponse(@NonNull Call<Categories> call, @NonNull Response<Categories> response) {
                 //Close loading khi nhận đc response từ server
                 view.hideLoading();
                 if(response.isSuccessful() && response.body() != null){
                     view.setCategory(response.body().getCategories());
                 }else{
                     view.onErrorLoading(response.message());
                 }

             }

             @Override
             public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
                 view.hideLoading();
                 view.onErrorLoading(t.getLocalizedMessage());
             }
         });
    }


}
