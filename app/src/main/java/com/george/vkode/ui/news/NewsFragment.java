package com.george.vkode.ui.news;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.george.vkode.data.prefereces.PreferencesViewModel;
import com.george.vkode.databinding.FragmentNewsBinding;
import com.george.vkode.ui.viewModel.AccountViewModel;
import com.george.vkode.ui.viewModel.ViewModelFactory;

public class NewsFragment extends Fragment {

    FragmentNewsBinding binding;

    public static final String TAG = NewsFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        PreferencesViewModel preferencesViewModel = new ViewModelProvider(this).get(PreferencesViewModel.class);
        AccountViewModel accountViewModel = new ViewModelProvider(
                this,
                new ViewModelFactory(this.requireActivity().getApplication(), preferencesViewModel.getToken())
        ).get(AccountViewModel.class);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}