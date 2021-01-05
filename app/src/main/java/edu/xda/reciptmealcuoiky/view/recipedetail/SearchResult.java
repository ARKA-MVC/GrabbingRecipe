package edu.xda.reciptmealcuoiky.view.recipedetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.xda.reciptmealcuoiky.R;
import edu.xda.reciptmealcuoiky.adapter.ViewSearchResultAdapter;
import edu.xda.reciptmealcuoiky.model.Meals;
import edu.xda.reciptmealcuoiky.view.main.MainActivity;

public class SearchResult extends AppCompatActivity implements DetailView {
    private static final String EXTRA_DETAIL = "detail";
    @BindView(R.id.toolbarResult)
    Toolbar toolbar;

    @BindView(R.id.recyclerResult)
    RecyclerView recyclerView;

    @BindView(R.id.tvResult)
    TextView tv;

    @BindView(R.id.progressBarResult)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        ButterKnife.bind(this);
        initActionBar();
        initIntent();

    }

    private void initIntent() {
        Intent intent = getIntent();
        tv.setText("Search result for: " + intent.getStringExtra(MainActivity.EXTRA_SEARCH));
        DetailPresenter presenter = new DetailPresenter(this);
        presenter.getByName(intent.getStringExtra(MainActivity.EXTRA_SEARCH));
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setMeal(Meals.Meal meal) {

    }

    @Override
    public void onErrorLoading(String err) {

    }

    @Override
    public void searchMeal(List<Meals.Meal> meals) {
        ViewSearchResultAdapter searchResultAdapter = new ViewSearchResultAdapter(this, meals);
        recyclerView.setAdapter(searchResultAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(true);
        searchResultAdapter.notifyDataSetChanged();

        searchResultAdapter.setOnItemClickListener((v, pos) -> {
            TextView mealName = v.findViewById(R.id.mealName);
            Intent intent = new Intent(this, RecipeDetailActivity.class);
            intent.putExtra(EXTRA_DETAIL, mealName.getText().toString());
            startActivity(intent);
        });
    }
}