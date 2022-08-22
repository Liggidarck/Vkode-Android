package com.george.vkode.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.george.vkode.R;
import com.george.vkode.data.prefereces.PreferencesViewModel;
import com.george.vkode.databinding.FragmentProfileBinding;
import com.george.vkode.network.model.user.get.UserPhoto;
import com.george.vkode.ui.viewModel.AccountViewModel;
import com.george.vkode.ui.viewModel.FriendsViewModel;
import com.george.vkode.ui.viewModel.LocalUserViewModel;
import com.george.vkode.ui.viewModel.ViewModelFactory;

import java.util.List;
import java.util.Objects;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    LocalUserViewModel localUserViewModel;
    PreferencesViewModel preferencesViewModel;
    AccountViewModel accountViewModel;
    FriendsViewModel friendsViewModel;

    public static final String TAG = ProfileFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.toolbarProfile);
        binding.toolbarProfile.setNavigationOnClickListener(v -> requireActivity().onBackPressed());

        initViewModel();

        int userId = preferencesViewModel.getUserId();

        getProfileAvatar();
        getBaseInfo(userId);

        return root;
    }

    private void initViewModel() {
        localUserViewModel = new ViewModelProvider(ProfileFragment.this.requireActivity())
                .get(LocalUserViewModel.class);

        preferencesViewModel = new ViewModelProvider(ProfileFragment.this.requireActivity())
                .get(PreferencesViewModel.class);

        friendsViewModel = new ViewModelProvider(this,
                new ViewModelFactory(ProfileFragment.this.requireActivity().getApplication(), preferencesViewModel.getToken())
        ).get(FriendsViewModel.class);

        accountViewModel = new ViewModelProvider(
                ProfileFragment.this.requireActivity(),
                new ViewModelFactory(ProfileFragment.this.requireActivity().getApplication(), preferencesViewModel.getToken())
        ).get(AccountViewModel.class);
    }

    private void getProfileAvatar() {
        accountViewModel.getUserPhoto().observe(ProfileFragment.this.requireActivity(), photo -> {
            List<UserPhoto> photos = photo.getResponse();
            for (UserPhoto userPhoto : photos) {
                Glide.with(ProfileFragment.this.requireActivity())
                        .load(userPhoto.getPhoto_400_orig())
                        .centerCrop()
                        .into(binding.avatarProfile);
            }
        });
    }

    private void getBaseInfo(int userId) {
        localUserViewModel.getUserById(userId).observe(ProfileFragment.this.requireActivity(), user -> {
            String username = user.getFirstName() + " " + user.getLastName();
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(user.getScreenName());
            binding.textViewUsername.setText(username);
            binding.textViewStatus.setText(user.getStatus());
        });

        friendsViewModel.getUserFriends("hints", "photo_200_orig,online").observe(ProfileFragment.this.requireActivity(), friends -> {
            int count = friends.getResponse().getCount();
            String friendsCount = count + " друзей";
//            binding.textViewFriends.setText(friendsCount);
        });

        accountViewModel.getFollowers("photo_200_orig,online").observe(ProfileFragment.this.requireActivity(), followers -> {
            int count = followers.getResponse().getCount();
            String followersCount = count + " подписчиков";
//            binding.textViewFollowers.setText(followersCount);
        });
    }
}