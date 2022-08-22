package com.george.vkode.ui.newsfeed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.george.vkode.R;
import com.george.vkode.network.model.common.photo.PhotoSize;
import com.george.vkode.network.model.newsfeed.get.NewsfeedAttachment;
import com.george.vkode.network.model.newsfeed.get.NewsfeedItems;

import java.util.ArrayList;
import java.util.List;

public class NewsfeedAdapter extends RecyclerView.Adapter<NewsfeedAdapter.ViewHolder> {

    Context context;
    List<NewsfeedItems> newsfeedItems;
    List<PhotoSize> photoSizes;

    public NewsfeedAdapter(Context context, List<NewsfeedItems> newsfeedItems, List<PhotoSize> photoSizes) {
        this.context = context;
        this.newsfeedItems = newsfeedItems;
        this.photoSizes = photoSizes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newsfeed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsfeedItems newsfeedItem = newsfeedItems.get(position);
        PhotoSize photoSize = photoSizes.get(position);

        holder.textViewNewsfeedText.setText(newsfeedItem.getText());

    }

    @Override
    public int getItemCount() {
        return newsfeedItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarNewsfeedItem, imageViewNewsfeedItem;
        TextView textViewNewsfeedTitle, textViewNewsfeedTimeCreate,
                textViewNewsfeedText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarNewsfeedItem = itemView.findViewById(R.id.avatarNewsfeedItem);
            imageViewNewsfeedItem = itemView.findViewById(R.id.imageViewNewsfeedItem);
            textViewNewsfeedTitle = itemView.findViewById(R.id.textViewNewsfeedTitle);
            textViewNewsfeedTimeCreate = itemView.findViewById(R.id.textViewNewsfeedTimeCreate);
            textViewNewsfeedText = itemView.findViewById(R.id.textViewNewsfeedText);
        }
    }

}
