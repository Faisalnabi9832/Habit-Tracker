package com.regexbyte.habittracker.login;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.regexbyte.habittracker.Base.BasePresenter;
import com.regexbyte.habittracker.MainActivity.MainActivity;
import com.regexbyte.habittracker.Models.Modeforlogin;
import com.regexbyte.habittracker.R;
import com.regexbyte.habittracker.common.ApiInterface;
import com.regexbyte.habittracker.common.ApiUtils;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter extends BasePresenter<LoginView> {

    ApiInterface apiInterface;

    public LoginPresenter(Context context) {
        super(context);
        apiInterface = ApiUtils.getRetrofit().create(ApiInterface.class);
    }

//    protected void authenticate() {
//
//        ifViewAttached(view -> {
//            String email = view.getEmail();
//            String passward = view.getpassward();
//            if (TextUtils.isEmpty(email)) {
//                view.setEmailWarning(context.getResources().getString(R.string.emailWarning));
//            } else if (TextUtils.isEmpty(passward)) {
//                view.setPasswardWarning(context.getResources().getString(R.string.passwardwarning));
//            } else {
//
//                if (hasInternetConnection()) {
//
//                    Modeforlogin modeforlogin = new Modeforlogin(email, passward);
//                    ProgressDialog progressDialog = new ProgressDialog(context);
//                    progressDialog.setMessage("Loading...");
//                    progressDialog.setCancelable(false);
//
//
//                    Drawable drawable = new ColorDrawable(Color.WHITE);
//                    progressDialog.getWindow().setBackgroundDrawable(drawable);
//
//                    progressDialog.show();
//
//
//
//                    Call<Modeforlogin> call = apiInterface.modeForLoginCall(modeforlogin);
//                    call.enqueue(new Callback<Modeforlogin>() {
//                        @Override
//                        public void onResponse(Call<Modeforlogin> call, Response<Modeforlogin> response) {
//                            if (response.isSuccessful()) {
//                                progressDialog.dismiss();
//                                Modeforlogin modeforloginResponse = response.body();
//                                if (modeforloginResponse != null) {
//                                    // Handle the API response here
//                                    // You can use modeforloginResponse.getMessage() and modeforloginResponse.getData()
//                                    view.showApiIntegrationStatus(true);
//                                    Intent intent = new Intent(context, MainActivity.class);
//                                   context.startActivity(intent);
//
//                                }
//                            } else {
//                                progressDialog.dismiss();
//                                try {
//                                    String errorBody = response.errorBody().string();
//                                    Log.e("API_ERROR", "Error Response: " + errorBody);
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                                Log.e("API_ERROR", "Error Response: " + response.errorBody());
//                                // Handle unsuccessful response
//                                view.showApiIntegrationStatus(false); // API integration failed
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<Modeforlogin> call, Throwable t) {
//                            Toast.makeText(context, "Failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                } else {
//                    view.showToast(context.getResources().getString(R.string.internet_connection_failed));
//                }
//            }
//        });
//    }
}
