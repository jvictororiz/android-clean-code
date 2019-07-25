package com.mycompany.exampleproject.service.call;

import com.mycompany.exampleproject.data.request.UserLoginRequest;
import com.mycompany.exampleproject.data.request.UserLoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("doLogin/")
    Call<UserLoginResponse> doLogin(UserLoginRequest loginRequest);

}
