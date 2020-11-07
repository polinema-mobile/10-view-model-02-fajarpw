package id.putraprima.mvvmlogin.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.UserModel;

public class HomeFragmentViewModel extends ViewModel {
    public MutableLiveData<UserModel> userModelMutableLiveData = new MutableLiveData<>();
    private UserModel userModel;

    public HomeFragmentViewModel(UserModel userModel) {
        this.userModel = userModel;
        this.userModelMutableLiveData.setValue(userModel);
    }

    public LiveData<UserModel> userModelLiveData(){
        return userModelMutableLiveData;
    }
}
