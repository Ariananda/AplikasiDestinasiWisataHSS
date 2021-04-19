package com.aria.aplikasidestinasiwisata.ui.destination;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.aria.aplikasidestinasiwisata.data.model.Destination;
import com.aria.aplikasidestinasiwisata.databinding.ActivityDestinationDetailBinding;

public class DestinationDetailActivity extends AppCompatActivity {
    public static final String KEY_DESTINATION = "destination";

    //ViewBinding
    private ActivityDestinationDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ViewBinding
        binding = ActivityDestinationDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Destination destination = getIntent().getParcelableExtra(KEY_DESTINATION);
        setupActionBar();
        populateViews(destination);

    }

    //Make action bar transparent
    private void setupActionBar() {
        getSupportActionBar().hide();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    //For populate data to views
    private void populateViews(final Destination destination) {
        binding.contentName.setText(destination.getName());
        binding.contentLocation.setText(destination.getLocation());
        binding.contentArticle.setText(destination.getArticle());
        binding.contentTime.setText(destination.getTime());
        binding.contentFacilities.setText(destination.getFacilities());
        binding.contentAddress.setText(destination.getAddress());

        Glide.with(this)
                .load(destination.getPhoto())
                .into(binding.contentImg);

        binding.btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(destination.getMapUrl()));
                startActivity(intent);
            }
        });
    }

}
