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
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.george.vkode.R;
import com.george.vkode.data.prefereces.PreferencesViewModel;
import com.george.vkode.databinding.FragmentMenuBinding;
import com.george.vkode.ui.profile.ProfileFragment;
import com.george.vkode.ui.viewModel.LocalUserViewModel;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;
    private NavController navController;

    private LocalUserViewModel localUserViewModel;
    private PreferencesViewModel preferencesViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        navController = Navigation.findNavController(MenuFragment.this.requireActivity(),
                R.id.navHostFragmentMain);

        binding.cardProfile.setOnClickListener(v -> {
            navController.navigate(R.id.action_nav_menu_to_profileFragment);
        });

        localUserViewModel = new ViewModelProvider(MenuFragment.this.requireActivity())
                .get(LocalUserViewModel.class);

        preferencesViewModel = new ViewModelProvider(MenuFragment.this.requireActivity())
                .get(PreferencesViewModel.class);

        int userId = preferencesViewModel.getUserId();
        localUserViewModel.getUserById(userId).observe(MenuFragment.this.requireActivity(), user -> {
            String userFullName = user.getFirstName() + " " + user.getLastName();
            binding.nameProfileMenu.setText(userFullName);
        });

        return root;
    }
}
