package com.example.ui_frame;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityContract extends AppCompatActivity {

    private UserContractDBHelper userContractDbHelper;
    private OrganizationDBHelper organizationDbHelper;
    private EditText main_contractIdEditText;
    private EditText main_contractPwEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contract);

        main_contractIdEditText = findViewById(R.id.main_contractIdEditText);
        main_contractPwEditText = findViewById(R.id.main_contractPwEditText);

    }

    public void contractPrivateSignUpButtonClick(View view) {
        userContractDbHelper = new UserContractDBHelper(this);
        userContractDbHelper.insertRecord(main_contractIdEditText.getText().toString(), main_contractPwEditText.getText().toString(), "Private", "Bronze", "0:00", "0");
    }

    public void contractPublicSignUpButtonClick(View view) {
        userContractDbHelper = new UserContractDBHelper(this);
        organizationDbHelper = new OrganizationDBHelper(this);
        userContractDbHelper.insertRecord(main_contractIdEditText.getText().toString(), main_contractPwEditText.getText().toString(), "Public", "Bronze", "0:00", "0");
        organizationDbHelper.insertRecord(main_contractIdEditText.getText().toString(), "", "", "", "", "", "", "", "", "");

    }

}
