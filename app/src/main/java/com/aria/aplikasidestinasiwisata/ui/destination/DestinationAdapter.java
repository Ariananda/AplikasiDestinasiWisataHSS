package com.aria.aplikasidestinasiwisata.ui.destination;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.aria.aplikasidestinasiwisata.data.model.Destination;
import com.aria.aplikasidestinasiwisata.databinding.RowItemBinding;

import java.util.ArrayList;
import java.util.List;

import static com.aria.aplikasidestinasiwisata.ui.destination.DestinationDetailActivity.KEY_DESTINATION;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder> {
    private final List<Destination> destinationList = new ArrayList<>();
    private Context context;

    public void setDestinationList(List<Destination> destinationList) {
        this.destinationList.clear();
        this.destinationList.addAll(destinationList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        this.context = parent.getContext();
        return new DestinationViewHolder(RowItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        final Destination destination = destinationList.get(position);

        holder.binding.contentName.setText(destination.getName());
        holder.binding.contentLocation.setText(destination.getLocation());
        holder.binding.contentArticle.setText(destination.getArticle());

        Glide.with(context)
                .load(destination.getPhoto())
                .apply(new RequestOptions().override(550, 130))
                .into(holder.binding.contentImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DestinationDetailActivity.class);
                intent.putExtra(KEY_DESTINATION, destination);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public static class DestinationViewHolder extends RecyclerView.ViewHolder {

        //View Binding
        private final RowItemBinding binding;

        public DestinationViewHolder(RowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
