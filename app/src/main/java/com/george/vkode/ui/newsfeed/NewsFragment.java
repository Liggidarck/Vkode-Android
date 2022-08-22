package com.george.vkode.ui.newsfeed;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.george.vkode.data.prefereces.PreferencesViewModel;
import com.george.vkode.databinding.FragmentNewsBinding;
import com.george.vkode.network.model.common.link.Link;
import com.george.vkode.network.model.common.photo.Photo;
import com.george.vkode.network.model.common.photo.PhotoSize;
import com.george.vkode.network.model.newsfeed.get.NewsfeedAttachment;
import com.george.vkode.network.model.newsfeed.get.NewsfeedItems;
import com.george.vkode.network.model.user.get.UserPhoto;
import com.george.vkode.ui.menu.MenuFragment;
import com.george.vkode.ui.viewModel.AccountViewModel;
import com.george.vkode.ui.viewModel.NewsfeedViewModel;
import com.george.vkode.ui.viewModel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewsFragment extends Fragment {

    FragmentNewsBinding binding;

    NewsfeedAdapter newsfeedAdapter;
    List<NewsfeedItems> newsfeedItems;
    List<PhotoSize> photoSizes;


    PreferencesViewModel preferencesViewModel;
    NewsfeedViewModel newsfeedViewModel;
    AccountViewModel accountViewModel;

    public static final String TAG = NewsFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsfeedItems = new ArrayList<>();
        photoSizes = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initViewModels();

        getUserAvatar();

        initRecyclerView();

        newsfeedViewModel.getNewsfeed("post", 5, null).observe(NewsFragment.this.requireActivity(), newsfeedResponse -> {

            newsfeedItems.addAll(newsfeedResponse.getResponse().getItems());
            newsfeedAdapter.notifyDataSetChanged();

            for(NewsfeedItems newsfeedItem: newsfeedItems) {
                List<NewsfeedAttachment> attachments = newsfeedItem.getAttachments();

                for (NewsfeedAttachment attachment: attachments) {
                    String postType = attachment.getType();

                    if(postType.equals("photo")) {
                        Photo photo = attachment.getPhoto();

                        photoSizes.addAll(photo.getSizes());
                        newsfeedAdapter.notifyDataSetChanged();
                    }

                    if(postType.equals("link")) {
                        Link link = attachment.getLink();
                        Log.d(TAG, "link title: " + link.getTitle());
                    }

                }

            }

        });

        return root;
    }

    private void getUserAvatar() {
        accountViewModel.getUserPhoto().observe(NewsFragment.this.requireActivity(), userPhotoResponse -> {
            List<UserPhoto> photos = userPhotoResponse.getResponse();
            for(UserPhoto userPhoto: photos) {

                Glide.with(NewsFragment.this.requireActivity())
                        .load(userPhoto.getPhoto_100())
                        .centerCrop()
                        .into(binding.newPostCardView.avatarProfilePost);

                Glide.with(NewsFragment.this.requireActivity())
                        .load(userPhoto.getPhoto_200_orig())
                        .centerCrop()
                        .into(binding.storyCardView.avatarProfileStory);

            }
        });
    }

    private void initRecyclerView() {
        newsfeedAdapter = new NewsfeedAdapter(NewsFragment.this.requireActivity(), newsfeedItems, photoSizes);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        binding.recyclerViewNewsfeed.setLayoutManager(manager);
        binding.recyclerViewNewsfeed.setHasFixedSize(false);
        binding.recyclerViewNewsfeed.setAdapter(newsfeedAdapter);

    }

    private void initViewModels() {
        preferencesViewModel = new ViewModelProvider(this).get(PreferencesViewModel.class);

        newsfeedViewModel = new ViewModelProvider(this,
                new ViewModelFactory(this.requireActivity().getApplication(), preferencesViewModel.getToken())
        ).get(NewsfeedViewModel.class);

        accountViewModel = new ViewModelProvider(this,
                new ViewModelFactory(NewsFragment.this.requireActivity().getApplication(), preferencesViewModel.getToken())
        ).get(AccountViewModel.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
