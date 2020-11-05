package id.putraprima.mvvmlogin.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mvvmlogin.models.UserModel;

public class HomeFragmentViewModelFactory implements ViewModelProvider.Factory {
    private UserModel userModel;

    public HomeFragmentViewModelFactory(UserModel userModel) {
        this.userModel = userModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(HomeFragmentViewModel.class)){
            return (T) new HomeFragmentViewModel(userModel);
        }
        throw new IllegalArgumentException("Viewmodel yang diminta HomeFragmentViewModel");
    }
}
