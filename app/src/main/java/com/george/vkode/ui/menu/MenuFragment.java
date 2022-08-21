package com.george.vkode.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.george.vkode.R;
import com.george.vkode.data.prefereces.PreferencesViewModel;
import com.george.vkode.databinding.FragmentMenuBinding;
import com.george.vkode.network.model.user.get.UserPhoto;
import com.george.vkode.ui.viewModel.AccountViewModel;
import com.george.vkode.ui.viewModel.LocalUserViewModel;
import com.george.vkode.ui.viewModel.ViewModelFactory;

import java.util.List;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;
    private NavController navController;

    LocalUserViewModel localUserViewModel;
    PreferencesViewModel preferencesViewModel;
    AccountViewModel accountViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        NavController navController =
                NavHostFragment.findNavController(this);

        localUserViewModel = new ViewModelProvider(MenuFragment.this.requireActivity())
                .get(LocalUserViewModel.class);

        preferencesViewModel = new ViewModelProvider(MenuFragment.this.requireActivity())
                .get(PreferencesViewModel.class);

        accountViewModel = new ViewModelProvider(
                MenuFragment.this.requireActivity(),
                new ViewModelFactory(MenuFragment.this.requireActivity().getApplication(), preferencesViewModel.getToken())
        ).get(AccountViewModel.class);

        binding.cardProfile.setOnClickListener(v -> {
            navController.navigate(R.id.action_nav_menu_to_profileFragment);
        });

        int userId = preferencesViewModel.getUserId();
        localUserViewModel.getUserById(userId).observe(MenuFragment.this.requireActivity(), user -> {
            String userFullName = user.getFirstName() + " " + user.getLastName();
            binding.nameProfileMenu.setText(userFullName);
        });

        accountViewModel.getUserPhoto().observe(MenuFragment.this.requireActivity(), photo -> {
            List<UserPhoto> photos = photo.getResponse();
            for(UserPhoto userPhoto: photos) {
                Glide.with(MenuFragment.this.requireActivity())
                        .load(userPhoto.getPhoto_100())
                        .centerCrop()
                        .into(binding.avatarProfileMenu);
            }
        });

        return root;
    }
}
