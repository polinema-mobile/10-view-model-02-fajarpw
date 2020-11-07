package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentHomeBinding;
import id.putraprima.mvvmlogin.models.UserModel;
import id.putraprima.mvvmlogin.viewmodels.HomeFragmentViewModel;
import id.putraprima.mvvmlogin.viewmodels.HomeFragmentViewModelFactory;

public class HomeFragment extends Fragment {

    private HomeFragmentViewModel homeFragmentViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);

        HomeFragmentViewModelFactory homeFragmentViewModelFactory = new HomeFragmentViewModelFactory(new UserModel(getArguments().getString("email"),getArguments().getString("password")));
        homeFragmentViewModel = new ViewModelProvider(this,homeFragmentViewModelFactory).get(HomeFragmentViewModel.class);
        View view = binding.getRoot();
        binding.setViewModel(homeFragmentViewModel);
        binding.setLifecycleOwner(this);
        return view;
    }
}