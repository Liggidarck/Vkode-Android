package com.george.vkode.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.george.vkode.R;
import com.george.vkode.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        binding.btnLogin.setOnClickListener(v -> {
            Fragment authFragment = new AuthFragment();
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayoutLogin, authFragment)
                    .commit();
        });
        
        return root;
    }
}
