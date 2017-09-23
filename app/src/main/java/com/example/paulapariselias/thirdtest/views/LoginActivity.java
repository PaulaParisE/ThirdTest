package com.example.paulapariselias.thirdtest.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.paulapariselias.thirdtest.MainActivity;
import com.example.paulapariselias.thirdtest.R;
import com.example.paulapariselias.thirdtest.data.CurrentUser;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;

import java.util.Arrays;


public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if ( new CurrentUser().getCurrentUser() != null){
            logged();

        }else{
            singUp();
        }



    }


    private void singUp() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(Arrays.asList(
                                new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                        .setTheme(R.style.LoginTheme)
                        .build(),
                RC_SIGN_IN);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RC_SIGN_IN == requestCode) {
            if (ResultCodes.OK == resultCode) {
                logged();
            }
        }

    }

    private void logged() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


    }

}

