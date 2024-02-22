package com.regexbyte.habittracker.login;
import com.regexbyte.habittracker.Base.BaseView;

public interface LoginView extends BaseView {

    String getEmail();
    String getpassward();

     void setEmailWarning(String warning);
    void setPasswardWarning(String warning);


        void showApiIntegrationStatus(boolean isSuccessful);
    }


