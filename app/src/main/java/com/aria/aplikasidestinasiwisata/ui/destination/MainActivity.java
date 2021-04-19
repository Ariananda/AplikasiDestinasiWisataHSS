package com.aria.aplikasidestinasiwisata.ui.destination;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.aria.aplikasidestinasiwisata.data.DestinationDummy;
import com.aria.aplikasidestinasiwisata.data.model.Destination;
import com.aria.aplikasidestinasiwisata.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ViewBinding
    private ActivityMainBinding binding;

    private final DestinationAdapter adapter = new DestinationAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupRecyclerView();

        List<Destination> destinationList = DestinationDummy.getDestinationList();
        adapter.setDestinationList(destinationList);
    }

    private void setupRecyclerView() {
        binding.rvDestination.setLayoutManager(new LinearLayoutManager(this));
        binding.rvDestination.setHasFixedSize(true);
        binding.rvDestination.setAdapter(adapter);
    }
}
