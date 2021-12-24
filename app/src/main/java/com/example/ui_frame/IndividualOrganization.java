package com.example.ui_frame;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IndividualOrganization extends AppCompatActivity {

    private OrganizationDBHelper organizationDBHelper;
    private TextView setName;
    private TextView setInfo;
    private TextView setAddress;
    private TextView setPhoneNumber;
    private String Name;
    private String Info;
    private String ID;
    private String Address;
    private String PhoneNumber;
    private String Category;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_organization);

        Intent getOrganizationName = getIntent();
        String id = getOrganizationName.getStringExtra("ID");

        organizationDBHelper = new OrganizationDBHelper(this);
        setName = findViewById(R.id.individual_NameTextView);
        setInfo = findViewById(R.id.individual_InfoSetTextView);
        setAddress = findViewById(R.id.individual_AddressSetTextView);
        setPhoneNumber = findViewById(R.id.individual_PhoneNumberSetTextView);

        Cursor cursor = organizationDBHelper.readRecordOrderByID();
        while(cursor.moveToNext()){
            ID = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ID));
            if(ID.equals(id)){
                Name = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_NAME));
                Info = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_INFO));
                Address = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ADDRESS));
                PhoneNumber = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_PHONENUMBER));
                Category = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_CATEGORY));
                break;
            }
        }
        setName.setText(Name);
        setInfo.setText(Info);
        setAddress.setText("주소 : " + Address);
        setPhoneNumber.setText("연락처 : " + PhoneNumber);
    }

    // 실제로는 DB에서 해당하는 name에 대한 기관의 정보를 가져온 후
    // 애플리케이션 화면에 띄워야 함

    // 후원메뉴, 정보, 리뷰는 서브 탭으로 분류
    public void individual_sponButtonClick(View view){
        Intent intent = new Intent(this, IndividualOrganizationSub.class);
        intent.putExtra("ID", ID);
        intent.putExtra("sub_category", "spon");
        startActivity(intent);
    }

    public void individual_infoButtonClick(View view){
        Intent intent = new Intent(this, IndividualOrganizationSub.class);
        intent.putExtra("ID", ID);
        intent.putExtra("sub_category", "info");
        startActivity(intent);
    }

    public void individual_reviewButtonClick(View view){
        Intent intent = new Intent(this, IndividualOrganizationSub.class);
        intent.putExtra("ID", ID);
        intent.putExtra("sub_category", "review");
        startActivity(intent);
    }

    public void individual_reservationButtonClick(View view){
        Intent intent = new Intent(this, IndividualOrganizationSub.class);
        intent.putExtra("ID", ID);
        intent.putExtra("sub_category", "reservation");
        startActivity(intent);
        finish();
    }

    public void individual_backButtonClick(View view){
        Intent intent = new Intent(this, CategoryOrganizationList.class);
        intent.putExtra("Category_name", Category);
        startActivity(intent);
        finish();
    }
}
