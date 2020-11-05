package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding;
import id.putraprima.mvvmlogin.models.UserModel;
import id.putraprima.mvvmlogin.viewmodels.LoginFragmentViewModel;
import id.putraprima.mvvmlogin.viewmodels.LoginFragmentViewModelFactory;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }


    private LoginFragmentViewModel loginFragmentViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false);
        LoginFragmentViewModelFactory loginFragmentViewModelFactory = new LoginFragmentViewModelFactory(new UserModel("user@gmail.com","user"));
        loginFragmentViewModel = new ViewModelProvider(this,loginFragmentViewModelFactory).get(LoginFragmentViewModel.class);
        View view = binding.getRoot();
        binding.setViewModel(loginFragmentViewModel);
        binding.setLifecycleOwner(this);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginFragmentViewModel.isLogin()){
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                }else {
                    binding.btnLogin.setError("Pastikan email dan password benar!");
                }
            }
        });

        return view;
    }
}