package com.rotemyanco.android_demo_app_005_lec_13;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;







public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        goToAuthIfNotLogin();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.chatFragment, R.id.profileFragment)
                .build();
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_activity_home);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }



    private boolean isLogin() {
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    private void goToAuthIfNotLogin() {
        if (!isLogin()) {
            // finish current activity before starting new one -->
            // prevents users pressing back btn and going into home activity without logging in or registering!!
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

}




