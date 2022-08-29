package com.rotemyanco.android_demo_app_005_lec_13;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.rotemyanco.android_demo_app_005_lec_13.ui.login.LoginFragment;






public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_host_container_activity_login, LoginFragment.getInstance())
                .commit();

    }



}