package com.regexbyte.habittracker.login;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.regexbyte.habittracker.Base.BaseActivity;
import com.regexbyte.habittracker.MainActivity.MainActivity;
import com.regexbyte.habittracker.R;
import com.regexbyte.habittracker.register.registerActivity;


public class LoginActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView, View.OnClickListener {

    private Button btn_login;
    private EditText edEmail;
    TextView register;
    private EditText edpassward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();

    }

    private void initUI() {
        btn_login=findViewById(R.id.btn_login);


        btn_login.setOnClickListener(this);
        edEmail=findViewById(R.id.Edforemaillogin);
        edpassward=findViewById(R.id.edpasswardforlogin);
        register=findViewById(R.id.register);
        register.setOnClickListener(this);



    }


    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        if (presenter==null)
        {
            return new LoginPresenter(this);
        }
        return  presenter;
    }

    @Override
    public String getEmail() {

        return edEmail.getText().toString();
    }

    @Override
    public String getpassward() {
        return edpassward.getText().toString();
    }

    @Override
    public void setEmailWarning(String warning) {
        edEmail.setError(warning);

    }

    @Override
    public void setPasswardWarning(String warning) {
        edpassward.setError(warning);
    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.btn_login) {
            presenter.authenticate();



        } else if (id == R.id.register){

                Intent intent = new Intent(LoginActivity.this, registerActivity.class);
                startActivity(intent);
            }

        }


    public void showApiIntegrationStatus(boolean isSuccessful) {
        if (isSuccessful) {
            Toast.makeText(this, "API integration successful", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "API integration failed", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void finish() {

    }
}