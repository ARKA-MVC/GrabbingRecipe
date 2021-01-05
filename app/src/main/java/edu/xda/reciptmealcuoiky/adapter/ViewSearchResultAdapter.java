package edu.xda.reciptmealcuoiky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.xda.reciptmealcuoiky.R;
import edu.xda.reciptmealcuoiky.model.Meals;

public class ViewSearchResultAdapter extends RecyclerView.Adapter<ViewSearchResultAdapter.RecyclerViewHolder> {
    private List<Meals.Meal> meals;
    private Context context;
    private static ViewByCategoryAdapter.ClickListener clickListener;

    public ViewSearchResultAdapter(Context context, List<Meals.Meal> meals) {
        this.meals = meals;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewSearchResultAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_meal,
                viewGroup, false);
        return new ViewSearchResultAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewSearchResultAdapter.RecyclerViewHolder viewHolder, int i) {
        String strMealThumb = meals.get(i).getStrMealThumb();
            Picasso.get().load(strMealThumb).placeholder(R.drawable.shadow).into(viewHolder.mealThumb);

        String strMealName = meals.get(i).getStrMeal();
        viewHolder.mealName.setText(strMealName);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.mealThumb)
        ImageView mealThumb;
        @BindView(R.id.mealName)
        TextView mealName;
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ViewByCategoryAdapter.ClickListener clickListener) {
        ViewSearchResultAdapter.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }
}
