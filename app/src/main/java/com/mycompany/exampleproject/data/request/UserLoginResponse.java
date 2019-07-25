package com.mycompany.exampleproject.data.request;

import android.os.Parcel;
import android.os.Parcelable;

public class UserLoginResponse implements Parcelable {
    private String login;
    private String password;

    private UserLoginResponse(Parcel in) {
        login = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final Creator<UserLoginResponse> CREATOR = new Creator<UserLoginResponse>() {
        @Override
        public UserLoginResponse createFromParcel(Parcel in) {
            return new UserLoginResponse(in);
        }

        @Override
        public UserLoginResponse[] newArray(int size) {
            return new UserLoginResponse[size];
        }
    };
}
