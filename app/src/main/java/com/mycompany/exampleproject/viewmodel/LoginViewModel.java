package com.mycompany.exampleproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mycompany.exampleproject.data.request.UserLoginRequest;
import com.mycompany.exampleproject.data.request.UserLoginResponse;
import com.mycompany.exampleproject.repository.LoginRepository;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends BaseViewModel {
    private LoginRepository loginRepository = new LoginRepository();
    public MutableLiveData<UserLoginResponse> login = new MutableLiveData<>();

    public void doLogin(String user, String password) {
        loading.setValue(true);
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setLogin(user);
        userLoginRequest.setPassword(password);
        UserLoginResponse responseData = getResponseData(loginRepository.doLogin(userLoginRequest));
        if (responseData != null) {
            login.setValue(responseData);
        }
        loading.setValue(false);
    }
}
