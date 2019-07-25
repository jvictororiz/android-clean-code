package com.mycompany.exampleproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mycompany.exampleproject.data.request.UserLoginResponse;

import java.io.IOException;

import retrofit2.Call;

public class BaseViewModel extends ViewModel {
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();

    protected static<T> T getResponseData(Call<T> retrofitCall) {
        try {
            return retrofitCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
