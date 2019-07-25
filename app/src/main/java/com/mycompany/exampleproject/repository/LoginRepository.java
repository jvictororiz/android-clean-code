package com.mycompany.exampleproject.repository;

import com.mycompany.exampleproject.data.request.UserLoginRequest;
import com.mycompany.exampleproject.data.request.UserLoginResponse;
import com.mycompany.exampleproject.service.BackendModule;
import com.mycompany.exampleproject.service.call.UserService;

import retrofit2.Call;

public class LoginRepository {
    private UserService userService = BackendModule.build().create(UserService.class);

    public Call<UserLoginResponse> doLogin(UserLoginRequest userLoginRequest) {
        return userService.doLogin(userLoginRequest);
    }
}
