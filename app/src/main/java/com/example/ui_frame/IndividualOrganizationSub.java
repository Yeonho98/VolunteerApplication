package com.example.ui_frame;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IndividualOrganizationSub extends AppCompatActivity {

    private OrganizationDBHelper organizationDBHelper;
    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_organization_sub);

        Intent get_sub_category = getIntent();
        String sub_category = get_sub_category.getStringExtra("sub_category");

        TextView subMenuTextView = findViewById(R.id.individualSub_subMenuTextView);
        TextView infoTextView = findViewById(R.id.individualSub_infoTextView);

        Log.i("individualSub", sub_category);

        subMenuTextView.setText("< " + sub_category + " >");

        String spon = " ";
        String reservation = "";
        String review = "";
        String info = " ";
        id = get_sub_category.getStringExtra("ID");

        organizationDBHelper = new OrganizationDBHelper(this);

        Cursor cursor = organizationDBHelper.readRecordOrderByID();
        while(cursor.moveToNext()) {
            String ID = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ID));
            if(ID.equals(id)){
                spon = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_SPON_INFO));
                reservation = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_RESERVATION));
                review = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_REVIEW));
                info = cursor.getString(cursor.getColumnIndexOrThrow(OrganizationSetting.OrganizationInfo.COLUMN_ORGANIZATION_INFO));
            }
        }

        if (sub_category.equals("spon")){
            infoTextView.setText(spon);
        }

        else if (sub_category.equals("reservation")) {
            infoTextView.setText(reservation);
        }

        else if (sub_category.equals("review")) {
            infoTextView.setText(review);
        }

        else if (sub_category.equals("info")) {
            infoTextView.setText(info);
        }

    }


    public void individualSub_backButtonClick(View view){
        Intent intent = new Intent(this, IndividualOrganization.class);
        intent.putExtra("ID", id);
        startActivity(intent);
        finish();
    }


}
