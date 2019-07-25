package com.mycompany.exampleproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mycompany.exampleproject.data.request.UserLoginRequest;
import com.mycompany.exampleproject.data.request.UserLoginResponse;
import com.mycompany.exampleproject.repository.LoginRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    private LoginRepository loginRepository = new LoginRepository();
    public MutableLiveData<UserLoginResponse> login = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();


    public void doLogin(String user, String password) {
        loading.setValue(true);
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setLogin(user);
        userLoginRequest.setPassword(password);
        Call<UserLoginResponse> response = loginRepository.doLogin(userLoginRequest);
        response.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {

            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {

            }
        }
        loading.setValue(false);

    }
}
