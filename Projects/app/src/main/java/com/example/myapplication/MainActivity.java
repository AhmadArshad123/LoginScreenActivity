package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText CNICText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        show_hide_password();

    }

    public void show_hide_password()
    {
        EditText etPassword= (EditText) findViewById(R.id.password_field) ;
        ImageView iv_password = (ImageView) findViewById(R.id.show_hide_password);
        iv_password.setImageResource(R.drawable.show_password_icon);
        iv_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    iv_password.setImageResource(R.drawable.hide_password_icon);
                }
                else
                {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    iv_password.setImageResource(R.drawable.show_password_icon);
                }
            }
        });
    }

    public void setupViews()
    {
        CNICText = (EditText) findViewById(R.id.CNIC_field);
        CNICText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void afterTextChanged(Editable editable) {
                String value = CNICText.getText().toString();
                char[] ch= value.toCharArray();

                if (value.matches("^[0-9]{5}-[0-9]{7}-[0-9]$")) {
                    CNICText.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(R.drawable.ic_action_name), null);
                }
                else {
                    CNICText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

                }

            }
        });
    }





}