package com.example.riyaagrahari.evento;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private static final String TAG = "FACELOG";
    private FirebaseAuth mAuth;
    private CallbackManager mCallbackManager;
    private Button logoutButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
//        relativeLayout = (RelativeLayout1) rootView.findViewById(R.id.relativeLayout);
//        logoutButton = new Button(getActivity());
//        button.setText
//        return rootView;
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        logoutButton = (Button) view.findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                updateUI();
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        //FirebaseApp.initializeApp(this);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            updateUI();
        }
    }
    private void updateUI() {
        //System.out.println("Congrats!");
        Toast.makeText(getActivity(), "You are logged out", Toast.LENGTH_SHORT).show();

        Intent accountIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(accountIntent);
        //finish();
    }
}

