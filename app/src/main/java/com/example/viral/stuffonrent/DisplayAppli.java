package com.example.viral.stuffonrent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DisplayAppli extends AppCompatActivity {
    ImageView img1,img2,img3;

    TextView name,rent,city,companyname,contact,description;

    String image1,image2,image3,a_name,a_rent,a_city,a_description,a_contact,a_comoanyname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_appli);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        name=findViewById(R.id.name);
        rent=findViewById(R.id.rent);
        city=findViewById(R.id.city);
        companyname=findViewById(R.id.companyname);
        contact=findViewById(R.id.contact);
        description=findViewById(R.id.description);

        image1=getIntent().getStringExtra("image1");
        image2=getIntent().getStringExtra("image2");
        image3=getIntent().getStringExtra("image3");
        a_name=getIntent().getStringExtra("a_name");
        a_rent=getIntent().getStringExtra("a_rent");
        a_comoanyname=getIntent().getStringExtra("a_company_name");
        a_city=getIntent().getStringExtra("a_city");
        a_description=getIntent().getStringExtra("a_description");
        a_contact=getIntent().getStringExtra("mobile_number");

        Glide.with(DisplayAppli.this).load(image1).into(img1);
        Glide.with(DisplayAppli.this).load(image2).into(img2);
        Glide.with(DisplayAppli.this).load(image3).into(img3);
        name.setText(a_name);
        rent.setText(a_rent);
        companyname.setText(a_comoanyname);
        city.setText(a_city);
        contact.setText(a_contact);
        description.setText(a_description);

    }
}
