package com.rotemyanco.android_demo_app_005_lec_13.ui.register;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rotemyanco.android_demo_app_005_lec_13.R;
import com.rotemyanco.android_demo_app_005_lec_13.ui.login.LoginFragment;


public class RegisterFragment extends Fragment {

    private RegisterViewModel registerViewModel;


    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment getInstance() {
        return new RegisterFragment();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}