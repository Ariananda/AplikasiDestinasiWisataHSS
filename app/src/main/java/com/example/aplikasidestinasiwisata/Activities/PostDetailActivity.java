package com.example.aplikasidestinasiwisata.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aplikasidestinasiwisata.Model.Destination;
import com.example.aplikasidestinasiwisata.R;

public class PostDetailActivity extends AppCompatActivity {
    TextView tvTitle, tvLocation,tvDetail,tvJam,tvFasilitas, tvAddress;
    ImageView imgPhoto;
    Button btnUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        getSupportActionBar().hide();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        final Destination destination = getIntent().getParcelableExtra("key");

        imgPhoto = findViewById(R.id.content_img);
        tvTitle = findViewById(R.id.content_title);
        tvLocation = findViewById(R.id.content_location);
        tvDetail = findViewById(R.id.content_info);
        tvJam = findViewById(R.id.content_jam);
        tvFasilitas = findViewById(R.id.content_fasilitas);
        tvAddress = findViewById(R.id.content_address);
        btnUrl = findViewById(R.id.btn_url);

        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = destination.getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Glide.with(this).load(destination.getPhoto()).into(imgPhoto);
        tvTitle.setText(destination.getName());
        tvLocation.setText(destination.getLocation());
        tvDetail.setText(destination.getArticle());
        tvJam.setText(destination.getTime());
        tvFasilitas.setText(destination.getFasiltas());
        tvAddress.setText(destination.getAddress());

        Log.i("article",destination.getArticle());
        Log.i("image",destination.getPhoto());
    }

}
