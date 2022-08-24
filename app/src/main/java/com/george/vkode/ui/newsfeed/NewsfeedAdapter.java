package com.george.vkode.ui.newsfeed;

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

import java.util.List;

public class NewsfeedAdapter extends RecyclerView.Adapter<NewsfeedAdapter.ViewHolder> {

    Context context;
    List<NewsfeedUiItem> newsfeedItems;

    public NewsfeedAdapter(Context context, List<NewsfeedUiItem> newsfeedItems) {
        this.context = context;
        this.newsfeedItems = newsfeedItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newsfeed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsfeedUiItem newsfeedUiItem = newsfeedItems.get(position);
        String time = newsfeedUiItem.getDay() + " " + newsfeedUiItem.getMoth() + " " + newsfeedUiItem.getTime();

        holder.textViewNewsfeedTitle.setText(newsfeedUiItem.getTitle());
        holder.textViewNewsfeedText.setText(newsfeedUiItem.getText());
        holder.textViewNewsfeedTimeCreate.setText(time);

        Glide.with(context)
                .load(newsfeedUiItem.getPhoto())
                .centerCrop()
                .into(holder.avatarNewsfeedItem);

        Glide.with(context)
                .load(newsfeedUiItem.getPhotoPost())
                .into(holder.imageViewNewsfeedItem);

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
