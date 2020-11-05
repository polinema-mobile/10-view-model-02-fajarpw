package id.putraprima.mvvmlogin.viewmodels;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import id.putraprima.mvvmlogin.models.UserModel;

public class LoginFragmentViewModel extends ViewModel {

    private MutableLiveData<UserModel> userModelMutableLiveData = new MutableLiveData<>();
    private UserModel userModel;

    public String email, password;

    public LoginFragmentViewModel(UserModel userModel) {
        this.userModel = userModel;
        this.userModelMutableLiveData.setValue(this.userModel);
    }

    public boolean isLogin(){
        if(email.equals(userModel.getEmail()) && password.equals(userModel.getPassword())){
            return true;
        }else{
            return false;
            }
        }
        public LiveData<UserModel> userModelLiveData(){
        return userModelMutableLiveData;
        }
    }
