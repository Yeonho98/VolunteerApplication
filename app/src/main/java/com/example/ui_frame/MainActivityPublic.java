package com.example.ui_frame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPublic extends AppCompatActivity {

    private OrganizationDBHelper organizationDBHelper;
    private EditText OrganizationName;
    private EditText OrganizationInfo;
    private EditText SponInfo;
    private EditText ReservationInfo;
    private EditText Image;
    private EditText PhoneNumber;
    private EditText Address;
    private EditText Category;
    private Button SetApply;
    private TextView SetResult;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_public);

        OrganizationName = findViewById(R.id.public_organizationNameEditText);
        OrganizationInfo = findViewById(R.id.public_infoEditText);
        SponInfo = findViewById(R.id.public_sponInfoEdiText);
        ReservationInfo = findViewById(R.id.public_reservationEditText);
        PhoneNumber = findViewById(R.id.public_phoneNumberEditText);
        Address = findViewById(R.id.public_AddressEditText);
        Category = findViewById(R.id.public_CategoryEditText);
        SetApply = findViewById(R.id.public_dbSetButton);
        SetResult = findViewById(R.id.public_setResultTextView);

        organizationDBHelper = new OrganizationDBHelper(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID").toString();
    }

    public void dbSetButtonClick(View view) {
        organizationDBHelper.deleteRecord(id);
        organizationDBHelper.insertRecord(id, OrganizationName.getText().toString(), OrganizationInfo.getText().toString(), SponInfo.getText().toString(), "Review 정보 예시입니다.", ReservationInfo.getText().toString(), null, PhoneNumber.getText().toString(), Address.getText().toString(), Category.getText().toString());
        SetResult.setText("저장되었습니다!");
    }



}
