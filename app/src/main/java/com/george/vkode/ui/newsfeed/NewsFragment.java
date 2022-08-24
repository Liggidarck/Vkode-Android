package com.george.vkode.ui.newsfeed;

import android.icu.util.LocaleData;
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
import com.george.vkode.network.model.common.group.Group;
import com.george.vkode.network.model.common.photo.PhotoSize;
import com.george.vkode.network.model.newsfeed.get.NewsfeedAttachment;
import com.george.vkode.network.model.newsfeed.get.NewsfeedItem;
import com.george.vkode.network.model.user.get.UserPhoto;
import com.george.vkode.ui.viewModel.AccountViewModel;
import com.george.vkode.ui.viewModel.NewsfeedViewModel;
import com.george.vkode.ui.viewModel.ViewModelFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class NewsFragment extends Fragment {

    FragmentNewsBinding binding;

    NewsfeedAdapter newsfeedAdapter;
    List<NewsfeedUiItem> newsfeedUiItems;

    PreferencesViewModel preferencesViewModel;
    NewsfeedViewModel newsfeedViewModel;
    AccountViewModel accountViewModel;

    public static final String TAG = NewsFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsfeedUiItems = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initViewModels();

        getUserAvatar();

        initRecyclerView();

        newsfeedViewModel.getNewsfeed("post", 25, null).observe(NewsFragment.this.requireActivity(), newsfeedResponse -> {
            List<NewsfeedItem> newsfeedItems = newsfeedResponse.getResponse().getItems();
            List<Group> groupItems = newsfeedResponse.getResponse().getGroups();

            for (NewsfeedItem newsfeedItem : newsfeedItems) {
                List<NewsfeedAttachment> attachments = newsfeedItem.getAttachments();
                int id = Math.abs(newsfeedItem.getSource_id());
                int itemDate = newsfeedItem.getDate();

                Date date = new Date((long) itemDate * 1000L);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

                String formattedDate = dateFormat.format(date);
                String formattedTime = timeFormat.format(date);

                LocalDate localDate = LocalDate.parse(formattedDate);
                int day = localDate.getDayOfMonth();
                String moth = localDate.getMonth().toString();

                String photoPost = null;

                try {
                    for (NewsfeedAttachment attachment : attachments) {
                        List<PhotoSize> photoSizes = attachment.getPhoto().getSizes();

                        for (PhotoSize photoSize : photoSizes) {

                            String type = photoSize.getType();

                            if (type.equals("z")) {
                                photoPost = photoSize.getUrl();
                            }

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                for (Group group : groupItems) {
                    int groupId = group.getId();
                    Log.d(TAG, "group id: " + groupId);

                    if (id == groupId) {
                        String title = group.getName();
                        String text = newsfeedItem.getText();
                        String photo = group.getPhoto_200();
                        Log.d(TAG, "title group: " + title);

                        NewsfeedUiItem newsfeedUiItem = new NewsfeedUiItem(title, text, photo,
                                day, moth, formattedTime, photoPost);

                        newsfeedUiItems.add(newsfeedUiItem);
                        newsfeedAdapter.notifyDataSetChanged();
                    }

                }

            }

        });

        return root;
    }

    private void getUserAvatar() {
        accountViewModel.getUserPhoto().observe(NewsFragment.this.requireActivity(), userPhotoResponse -> {
            List<UserPhoto> photos = userPhotoResponse.getResponse();
            for (UserPhoto userPhoto : photos) {

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
        newsfeedAdapter = new NewsfeedAdapter(NewsFragment.this.requireActivity(), newsfeedUiItems);

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
