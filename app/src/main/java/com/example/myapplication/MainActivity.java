package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.Adapters.MainAdapter;
import com.example.myapplication.Models.MainModel;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burger, "Burger", "5", "Chicken Burger with extra cheese" ));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "15", "Medium size Pizza with extra cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "0", "Sale upt0 28th May"));
        list.add(new MainModel(R.drawable.fries, "French Fries", "2", "Aloo French Fries"));
        list.add(new MainModel(R.drawable.fries, "Fries", "4", "Aloo French Fries"));

        MainAdapter adapter = new MainAdapter(list , this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrdersActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
}