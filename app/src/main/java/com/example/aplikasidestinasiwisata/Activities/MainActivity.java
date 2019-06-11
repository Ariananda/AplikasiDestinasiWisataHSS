package com.example.aplikasidestinasiwisata.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aplikasidestinasiwisata.Adapter.CardViewAdapter;
import com.example.aplikasidestinasiwisata.DestinationData;
import com.example.aplikasidestinasiwisata.Model.Destination;
import com.example.aplikasidestinasiwisata.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Destination> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(DestinationData.getListData());
        showRecycleCard();
    }

    private void showRecycleCard() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewDestinationAdapter = new CardViewAdapter(this);
        cardViewDestinationAdapter.setListDestination(list);
        rvCategory.setAdapter(cardViewDestinationAdapter);
    }
}
