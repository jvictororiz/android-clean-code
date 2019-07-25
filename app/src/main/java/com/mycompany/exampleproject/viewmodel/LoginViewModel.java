package com.mycompany.exampleproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mycompany.exampleproject.data.request.UserLoginRequest;
import com.mycompany.exampleproject.data.request.UserLoginResponse;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<UserLoginResponse> login = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();


    public void doLogin(String user, String password) {
       loading.setValue(true);
       
       loading.setValue(false);

    }
}
