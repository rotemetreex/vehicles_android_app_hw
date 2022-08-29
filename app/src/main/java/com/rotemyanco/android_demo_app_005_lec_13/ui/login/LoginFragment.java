package com.rotemyanco.android_demo_app_005_lec_13.ui.login;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.rotemyanco.android_demo_app_005_lec_13.HomeActivity;
import com.rotemyanco.android_demo_app_005_lec_13.R;






public class LoginFragment extends Fragment implements View.OnClickListener {

    private LoginViewModel loginViewModel;

    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    private GoogleSignInClient mGoogleSignInClient;

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;
    private Button btnGoogleSinIn;
    private ProgressBar pbLoginFrag;

    private String email;
    private String password;


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);
        // [END config_signin]

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        etEmail = v.findViewById(R.id.et_email_frag_login);
        etPassword = v.findViewById(R.id.et_password_frag_login);

        btnLogin = v.findViewById(R.id.btn_login_frag_login);
        btnRegister = v.findViewById(R.id.btn_register_frag_login);
        btnGoogleSinIn = v.findViewById(R.id.btn_google_account_login_frag_login);
        pbLoginFrag = v.findViewById(R.id.pb_frag_login);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        btnLogin.setOnClickListener(this::onClick);
//        btnRegister.setOnClickListener(this::onClick);
//        btnGoogleSinIn.setOnClickListener(this::onClick);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnGoogleSinIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        Log.d("------- Login Fragment --------", "onClick: "+ "   email: "+ email+ "  password: "+password);

        // check if email and password are empty string or null
        // in case one string is null:
        if (email == null || password == null) {
            Toast.makeText(getContext(), "---- Error: password and email are both required! ----", Toast.LENGTH_SHORT).show();
        }
        // in case one string is empty:     *** regex ***
//        if (email == null || password == null) {
//            Toast.makeText(getContext(), "---- Error: both password and email must not be empty! ----", Toast.LENGTH_SHORT).show();
//        }
        if (v.getId() == R.id.btn_login_frag_login) {
            login(v);
        } else if (v.getId() == R.id.btn_register_frag_login){
            register(v);
        } else if (v.getId() == R.id.btn_google_account_login_frag_login) {
            signIn();
        }
        pbLoginFrag.setVisibility(View.VISIBLE);
    }

    private void login(View v) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {
                        pbLoginFrag.setVisibility(View.GONE);
                        Toast.makeText(getContext(), "onSuccess: "+authResult.getUser().getEmail(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), HomeActivity.class));
                    })
                    .addOnFailureListener(e -> {
                        pbLoginFrag.setVisibility(View.GONE);
                        Toast.makeText(getContext(), "onFailure: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
    }

    private void register(View v) {
        // TODO: 23/08/2022 SEND EMAIL & PASSWORD INFO IF WAS TYPED TO NEXT FRAGMENT
        // TODO: 23/08/2022 NAVIGATE TO REGISTER FRAGMENT!!!

        if (v.getId() == R.id.btn_register_frag_login) {
            Log.d("------------Login Fragment-----------", "redirected to register fragment");

            // in case the new member entered details and is redirected to register fragment,
            // set text email and password in the appropriate fields.

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {
                        pbLoginFrag.setVisibility(View.GONE);

                        startActivity(new Intent(getContext(), HomeActivity.class));

//                        // TODO: 23/08/2022 enter new user data into db
//                        // TODO: 23/08/2022 wait for confirmation or failure response
//                        // TODO: 23/08/2022 upon confirmation: login & navigate to home frag
                    })
                    .addOnFailureListener(e -> {
                        pbLoginFrag.setVisibility(View.GONE);
                        Toast.makeText(getContext(), "error, pls try again...", Toast.LENGTH_SHORT).show();
                        // TODO: 23/08/2022 upon failure: error message
                    });
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed-in (non-null) and update UI accordingly
//        updateUI(mAuth.getCurrentUser());
    }

    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }
    // [END auth_with_google]


    // [START signin]
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signin]

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            startActivity(new Intent(getContext(), HomeActivity.class));
        } else {
            // show login error
            Toast.makeText(getContext(), "login error", Toast.LENGTH_SHORT).show();
        }
    }



}




































//            getActivity()
//                    .getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frag_host_container_activity_login, RegisterFragment.getInstance())
//                    .commitNow();

//            navController.navigate(R.id.action_loginFragment_to_registerFragment);







//            NavHostFragment navHostFragment = (NavHostFragment) getParentFragmentManager().findFragmentById(R.id.frag_host_container_activity_login);
//            NavController navController = navHostFragment.getNavController();
//            Navigation.findNavController(getActivity(), R.id.frag_host_container_activity_login).navigate(R.id.action_loginFragment_to_registerFragment);

//            FragmentActivity fragmentActivity = getActivity();
//            FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
//            Fragment fragment = fragmentManager.findFragmentById(R.id.frag_host_container_activity_login);


//            Navigation.setViewNavController(fragment.getView(), Navigation.findNavController(fragmentActivity, fragment.getId()));
//            NavController navController = Navigation.findNavController(fragmentActivity, fragment.getId());



//            FragmentActivity fragmentActivity = getActivity().getSupportFragmentManager().findFragmentById(R.id.frag_host_container_activity_login);
//            NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.frag_host_container_activity_login);
//            NavController navController = navHostFragment.getNavController();

//            NavController navController = Navigation.findNavController(getActivity(), R.id.frag_host_container_activity_login);