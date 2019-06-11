package com.example.aplikasidestinasiwisata.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.aplikasidestinasiwisata.Activities.PostDetailActivity;
import com.example.aplikasidestinasiwisata.CustomClickListener;
import com.example.aplikasidestinasiwisata.Model.Destination;
import com.example.aplikasidestinasiwisata.R;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {
    public Context context;
    public ArrayList<Destination> listDestination;

    public CardViewAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Destination> getListDestination() {
        return listDestination;
    }

    public void setListDestination(ArrayList<Destination> listDestination) {
        this.listDestination = listDestination;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_content,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int position) {
        final Destination d = getListDestination().get(position);

        Glide.with(context)
                .load(d.getPhoto())
                .apply(new RequestOptions().override(550,130))
                .into(cardViewHolder.imgPhoto);

        cardViewHolder.tvName.setText(d.getName());
        cardViewHolder.tvLocation.setText(d.getLocation());
        cardViewHolder.tvArticle.setText(d.getArticle());

        cardViewHolder.btnFavorite.setOnClickListener(new CustomClickListener(position, new CustomClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context,getListDestination().get(position).getName()+" ditambah ke favorit",Toast.LENGTH_LONG).show();
            }
        }));
        cardViewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Telah dibagikan",Toast.LENGTH_SHORT).show();
            }
        });
        cardViewHolder.destination = d;
    }

    @Override
    public int getItemCount() {
        return getListDestination().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvLocation, tvArticle;
        ImageView imgPhoto;
        Button btnFavorite, btnShare;
        CardView cardView;
        Destination destination;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.content_title);
            tvLocation = itemView.findViewById(R.id.content_location);
            tvArticle = itemView.findViewById(R.id.content_info);
            imgPhoto = itemView.findViewById(R.id.content_img);

            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            btnShare = itemView.findViewById(R.id.btn_share);
            cardView = itemView.findViewById(R.id.card_view);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, PostDetailActivity.class);
            intent.putExtra("key",destination);
            context.startActivity(intent);
        }
    }
}
