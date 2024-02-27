package com.regexbyte.habittracker.register;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.regexbyte.habittracker.Base.BasePresenter;
import com.regexbyte.habittracker.Models.RegistrationModel;
import com.regexbyte.habittracker.R;
import com.regexbyte.habittracker.common.ApiInterface;
import com.regexbyte.habittracker.common.ApiUtils;
import com.regexbyte.habittracker.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterPresenter extends BasePresenter<registerview> {

    ApiInterface apiInterface;
    private ProgressDialog progressDialog;

    public RegisterPresenter(Context context) {

        super(context);
        apiInterface = ApiUtils.getRetrofit().create(ApiInterface.class);
    }
    protected void authenticate() {

        ifViewAttached(view -> {
            String fullName = view.getname();
            String email = view.getEmail();
            String mobileNo = view.getMobileNo();
            String password = view.getpassward();
            String confirmPassword = view.getConfirmPassward();

            if (TextUtils.isEmpty(fullName)) {
                view.setNameWarning(context.getResources().getString(R.string.nameWarning));
            } else if (TextUtils.isEmpty(email)) {
                view.setEmailWarning(context.getResources().getString(R.string.emailWarning));
            } else if (TextUtils.isEmpty(mobileNo)) {
                view.setMobileNoWarning(context.getResources().getString(R.string.mobileNoWarnig));
            } else if (TextUtils.isEmpty(password)) {
                view.setPasswardWarning(context.getResources().getString(R.string.passwardwarning));
            } else if (TextUtils.isEmpty(confirmPassword)) {
                view.setConfirmPasswardWarning(context.getResources().getString(R.string.passwardwarning));
            } else if (!password.equals(confirmPassword)) {

                view.setConfirmPasswardWarning(context.getResources().getString(R.string.password_mismatch_warning));
            } else {
                if (hasInternetConnection()) {



                    String[] nameParts = fullName.split(" ");
                    String firstName = "";
                    String lastName = "";

                    if (nameParts.length > 0) {
                        firstName = nameParts[0];
                    }
                    if (nameParts.length > 1) {
                        lastName = nameParts[1];
                    }
                    // Show a progress dialog while making the API call
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage("Registering...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    RegistrationModel registrationData = new RegistrationModel(firstName, lastName, email, mobileNo, password,1,"faisl",1,1);


                    Call<RegistrationModel> call = apiInterface.REGISTRATION_MODEL_CALL(registrationData);
                    call.enqueue(new Callback<RegistrationModel>() {
                        @Override
                        public void onResponse(Call<RegistrationModel> call, Response<RegistrationModel> response) {
                            if (response.isSuccessful()) {
                                progressDialog.dismiss();
                                RegistrationModel registrationResponse = response.body();
                                if (registrationResponse != null) {

                                    view.showToast("Registration successful");
                                    Intent intent = new Intent(context, LoginActivity.class);
                                    context.startActivity(intent);

                                }
                            } else {

                                view.showToast("Registration failed"); // Show failure message
                            }
                        }

                        @Override
                        public void onFailure(Call<RegistrationModel> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(context, "Failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    view.showToast(context.getResources().getString(R.string.internet_connection_failed));
                }
            }
        });
    }


}
