package com.example.learnkotlin;

import static android.app.ProgressDialog.show;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragmentlogin extends Fragment{
    Button login,regiter;
    EditText email,password;
    TextView username;
    CallBackFragment callBackFragment;
    String lemail,lpass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onAttach(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("userFile",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

        login = view.findViewById(R.id.login);
        regiter = view.findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //sharedpreference
                lemail  = email.getText().toString();
                lpass = password.getText().toString();
                String uEmail,uPass;
                uEmail = sharedPreferences.getString("reemail",null);
                uPass = sharedPreferences.getString("repass",null);

                if(lemail.equals(uEmail) && lpass.equals(uPass)){
                    Toast.makeText(getContext(),"LogIn",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
        regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //callback
                if(callBackFragment != null){
                    callBackFragment.changeFragment();
                }
            }
        });



        return view;
    }
    public void setCallBackFragment(CallBackFragment callBackFragment){
        this.callBackFragment = callBackFragment;
    }

    public void callBackFragment(MainActivity mainActivity) {
    }
}
