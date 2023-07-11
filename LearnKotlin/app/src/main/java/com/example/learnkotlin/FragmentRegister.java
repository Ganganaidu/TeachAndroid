package com.example.learnkotlin;

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

public class FragmentRegister extends Fragment{
    Button regregister;
    EditText regemail,regpassword;
    TextView regreister1;
    String reemail,repass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    public void onAttach(@NonNull Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userFile",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment,container,false);
        regreister1 = view.findViewById(R.id.register1);
        regemail = view.findViewById(R.id.regemail);
        regpassword = view.findViewById(R.id.regpassword);

        regregister = view.findViewById(R.id.regregister);

        regregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //shredpreference
                reemail = regemail.getText().toString();
                repass = regpassword.getText().toString();

                editor.putString("reemail",reemail);
                editor.putString("repass",repass);
                editor.apply();;
                Toast.makeText(getContext(),"Registered",Toast.LENGTH_SHORT).show();



            }
        });



        return view;
    }
}
