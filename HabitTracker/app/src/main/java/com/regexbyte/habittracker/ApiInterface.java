package com.regexbyte.habittracker;

import com.regexbyte.habittracker.Models.Modeforlogin;
import com.regexbyte.habittracker.Models.RegistrationModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("authUser/signin")
    Call<Modeforlogin> modeForLoginCall(@Body Modeforlogin modeforlogin);

    @POST("authUser/registeruser")
    Call<RegistrationModel> REGISTRATION_MODEL_CALL(@Body RegistrationModel registrationModel);



}
