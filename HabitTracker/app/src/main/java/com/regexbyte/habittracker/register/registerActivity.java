package com.regexbyte.habittracker.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.regexbyte.habittracker.Base.BaseActivity;
import com.regexbyte.habittracker.R;
import com.regexbyte.habittracker.login.LoginActivity;

import java.time.Duration;


public class registerActivity extends BaseActivity<registerview,RegisterPresenter> implements registerview, View.OnClickListener {

    Button register;
    EditText edname,edemail ,edMobileNo,edpasswaed,edconfirmPassward;
    TextView alreadyaccount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
    }

    private void initUI(){

        edname=findViewById(R.id.editTextName);
        edemail=findViewById(R.id.edforemailregisrer);
        edMobileNo=findViewById(R.id.editTextMobile);
        edpasswaed=findViewById(R.id.edpasswardforregister);
        register=findViewById(R.id.btn_register);
        edconfirmPassward=findViewById(R.id.edconfirmpasswardforregister);
        alreadyaccount=findViewById(R.id.alreadyaccount);
        alreadyaccount.setOnClickListener(this);
        register.setOnClickListener(this);






    }

    @NonNull

    @Override
    public RegisterPresenter createPresenter() {
        if (presenter==null){
            return new RegisterPresenter(this);
        }

        return presenter;

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_register) {
            String passward=getpassward();
            String confirmpassward=getConfirmPassward();
            if (passward.equals(confirmpassward)){
                presenter.authenticate();


            }else {
                Toast.makeText(this,"Passward don't Matched", Toast.LENGTH_SHORT).show();
            }


            presenter.authenticate();

        } else if (id == R.id.alreadyaccount){

            Intent intent = new Intent(registerActivity.this, LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public String getEmail() {
        return edemail.getText().toString();
    }

    @Override
    public String getpassward() {
        return edpasswaed.getText().toString();
    }

    @Override
    public String getConfirmPassward() {
        return edconfirmPassward.getText().toString();
    }

    @Override
    public String getMobileNo() {
        return edMobileNo.getText().toString();
    }


    @Override
    public String getname(){
        return edname.getText().toString();
    }

    @Override
    public void setEmailWarning(String warning) {
        edemail.setError(warning);
    }

    @Override
    public void setPasswardWarning(String warning) {
        edpasswaed.setError(warning);

    }

    @Override
    public void setConfirmPasswardWarning(String warning) {
        edconfirmPassward.setError(warning);


    }

    @Override
    public void setNameWarning(String warning) {
        edname.setError(warning);

    }

    @Override
    public void setMobileNoWarning(String warning) {
        edMobileNo.setError(warning);

    }
}

