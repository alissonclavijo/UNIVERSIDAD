package com.nicolas.prylistviewpersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.nicolas.prylistviewpersonalizada.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<ListData>();

    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.pasta, R.drawable.burger, R.drawable.cake, R.drawable.fries, R.drawable.maggi, R.drawable.pizza, R.drawable.pancake};
        int[] ingredientsList = {R.string.pastaIngredients, R.string.burgerIngredients, R.string.cakeIngredients, R.string.friesIngredients, R.string.maggiIngredients, R.string.pizzaIngredients, R.string.pancakeIngredients};
        int[] descList = {R.string.pastaDesc, R.string.burgerDesc, R.string.cakeDesc, R.string.friesDesc, R.string.maggieDesc, R.string.pizzaDesc, R.string.pancakeDesc};
        String[] nameList = {"Pasta", "Burger", "Cake", "Fries", "Maggi", "Pizza", "Pancake"};
        String[] timeList = {"5 min", "10min", "5min", "12min", "28min", "30min", "15min"};

        for(int i=0; i<imageList[i];i++){
            listData= new ListData(nameList[i], timeList[i], ingredientsList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.ListView.setAdapter(listAdapter);
        binding.ListView.setClickable(true);

        binding.ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("name", nameList[position]);
                intent.putExtra("ingredient", ingredientsList[position]);
                intent.putExtra("desc", descList[position]);
                intent.putExtra("time", timeList[position]);
                intent.putExtra("image", imageList[position]);

                startActivity(intent);
            }
        });


    }
}