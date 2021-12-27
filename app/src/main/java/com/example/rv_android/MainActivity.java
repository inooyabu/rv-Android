package com.example.rv_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTourism;
    private ArrayList<Tourism> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTourism = findViewById(R.id.rv_tourism);
        rvTourism.setHasFixedSize(true);

        list.addAll(TourismData.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile) {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        }
        return true;
    }

    private void showRecyclerList() {
        rvTourism.setLayoutManager(new LinearLayoutManager(this));
        ListTourismAdapter listTourismAdapter = new ListTourismAdapter(list);
        rvTourism.setAdapter(listTourismAdapter);

        listTourismAdapter.setOnItemClickCallback(new ListTourismAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Tourism data) {

                Intent detailActivityIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailActivityIntent.putExtra(DetailActivity.EXTRA_NAME, data.getName());
                detailActivityIntent.putExtra(DetailActivity.EXTRA_ADDRESS, data.getAddress());
                detailActivityIntent.putExtra(DetailActivity.EXTRA_PHOTO, data.getPhoto());
                detailActivityIntent.putExtra(DetailActivity.EXTRA_DESCRIPTION, data.getDescription());
                startActivity(detailActivityIntent);

            }
        });
    }
}