package edu.xda.reciptmealcuoiky;

import android.app.AlertDialog;
import android.content.Context;

import edu.xda.reciptmealcuoiky.api.RecipeApi;
import edu.xda.reciptmealcuoiky.api.RetrofitInstance;

public class Utils {
    public static RecipeApi getApi() {
        return RetrofitInstance.getRetrofitInstance().create(RecipeApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
