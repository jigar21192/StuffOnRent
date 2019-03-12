package com.example.viral.stuffonrent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DisplayVehi extends AppCompatActivity {

    ImageView img1,img2,img3;

    TextView name,category,companyname,rent,city,contact,description;

    String image1,image2,image3,v_category,v_name,v_rent,v_city,v_description,v_contact,v_companyname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_vehi);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        name=findViewById(R.id.name);
        category=findViewById(R.id.category);
        companyname=findViewById(R.id.companynamev);
        rent=findViewById(R.id.rent);
        city=findViewById(R.id.city);
        contact=findViewById(R.id.contact);
        description=findViewById(R.id.description);

        image1=getIntent().getStringExtra("image1");
        image2=getIntent().getStringExtra("image2");
        image3=getIntent().getStringExtra("image3");
        v_category=getIntent().getStringExtra("v_category");
        v_name=getIntent().getStringExtra("v_name");
        v_rent=getIntent().getStringExtra("v_rent");
        v_companyname=getIntent().getStringExtra("v_company_name");
        v_city=getIntent().getStringExtra("v_city");
        v_description=getIntent().getStringExtra("v_description");
        v_contact=getIntent().getStringExtra("mobile_number");


        Glide.with(DisplayVehi.this).load(image1).into(img1);
        Glide.with(DisplayVehi.this).load(image2).into(img2);
        Glide.with(DisplayVehi.this).load(image3).into(img3);
        category.setText(v_category);
        name.setText(v_name);
        rent.setText(v_rent);
        companyname.setText(v_companyname);
        city.setText(v_city);
        contact.setText(v_contact);
        description.setText(v_description);

    }
}
