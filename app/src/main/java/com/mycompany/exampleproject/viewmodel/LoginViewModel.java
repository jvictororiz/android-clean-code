package com.mycompany.exampleproject.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.mycompany.exampleproject.R;
import com.mycompany.exampleproject.SuperApplication;
import com.mycompany.exampleproject.Utils.TextUtils;
import com.mycompany.exampleproject.data.request.UserLoginRequest;
import com.mycompany.exampleproject.data.request.UserLoginResponse;
import com.mycompany.exampleproject.repository.LoginRepository;

public class LoginViewModel extends BaseViewModel {
    private LoginRepository loginRepository = new LoginRepository();
    public MutableLiveData<UserLoginResponse> login = new MutableLiveData<>();
    public MutableLiveData<String> loginMessageError = new MutableLiveData<>();
    public MutableLiveData<String> passwordMessageError = new MutableLiveData<>();

    public void doLogin(String user, String password) {
        loading.setValue(true);
        boolean fieldsValid = validateLogin(user) && validatePassword(password);
        if (fieldsValid) {
            UserLoginRequest userLoginRequest = new UserLoginRequest();
            userLoginRequest.setLogin(user);
            userLoginRequest.setPassword(password);
            UserLoginResponse responseData = getResponseData(loginRepository.doLogin(userLoginRequest));
            if (responseData != null) {
                login.setValue(responseData);
            }
        }
        loading.setValue(false);
    }

    private boolean validatePassword(String password) {
        boolean validate = TextUtils.containsCapitalLetter(password)
                && TextUtils.containsAlphaNumeric(password)
                && TextUtils.containsSpecialCharacter(password);
        if (!validate && !password.isEmpty()) {
            loginMessageError.setValue(SuperApplication.getSuperApplication().getString(R.string.password_login));
        }
        return validate;
    }

    private boolean validateLogin(String user) {
        boolean validate = TextUtils.isCpf(user) || TextUtils.isEmail(user);
        if (!validate) {
            passwordMessageError.setValue(SuperApplication.getSuperApplication().getString(R.string.error_login));
        }
        return validate;
    }
}
