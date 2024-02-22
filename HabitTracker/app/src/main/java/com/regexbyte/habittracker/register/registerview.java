package com.regexbyte.habittracker.register;

import com.regexbyte.habittracker.Base.BaseView;

public interface registerview extends BaseView {
    String getEmail();
    String getpassward();
    String getConfirmPassward();
    String getMobileNo(); // Add this method
    String getname();
    void setEmailWarning(String warning);
    void setPasswardWarning(String warning);
    void setConfirmPasswardWarning(String warning);
    void setNameWarning(String warning);
    void setMobileNoWarning(String warning);
}
