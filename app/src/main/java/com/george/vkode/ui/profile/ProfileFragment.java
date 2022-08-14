package com.george.vkode.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.george.vkode.data.database.users.LocalUser;
import com.george.vkode.data.prefereces.PreferencesViewModel;
import com.george.vkode.databinding.FragmentProfileBinding;
import com.george.vkode.network.model.common.user.UserPhoto;
import com.george.vkode.ui.viewModel.AccountViewModel;
import com.george.vkode.ui.viewModel.LocalUserViewModel;
import com.george.vkode.ui.viewModel.ViewModelFactory;

import java.util.List;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    private LocalUserViewModel localUserViewModel;
    private PreferencesViewModel preferencesViewModel;

    public static final String TAG = ProfileFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.toolbarProfile.setNavigationOnClickListener(v -> requireActivity().onBackPressed());

        localUserViewModel = new ViewModelProvider(ProfileFragment.this.requireActivity())
                .get(LocalUserViewModel.class);

        preferencesViewModel = new ViewModelProvider(ProfileFragment.this.requireActivity())
                .get(PreferencesViewModel.class);

        int userId = preferencesViewModel.getUserId();
        localUserViewModel.getUserById(userId).observe(ProfileFragment.this.requireActivity(), user -> {
            String userFullName = user.getFirstName() + " " + user.getLastName();
            binding.toolbarProfile.setTitle(userFullName);

            Glide.with(ProfileFragment.this.requireActivity())
                    .load(user.getPhoto_400_orig())
                    .centerCrop()
                    .into(binding.avatarProfile);
        });

        return root;
    }
}
