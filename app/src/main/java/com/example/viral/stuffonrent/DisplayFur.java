package com.example.viral.stuffonrent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DisplayFur extends AppCompatActivity {
    ImageView img1,img2,img3;

    TextView name,rent,city,contact,description;

    String image1,image2,image3,f_name,f_rent,f_city,f_description,f_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fur);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        name=findViewById(R.id.name);
        rent=findViewById(R.id.rent);
        city=findViewById(R.id.city);
        contact=findViewById(R.id.contact);
        description=findViewById(R.id.description);

        image1=getIntent().getStringExtra("image1");
        image2=getIntent().getStringExtra("image2");
        image3=getIntent().getStringExtra("image3");
        f_name=getIntent().getStringExtra("f_name");
        f_rent=getIntent().getStringExtra("f_rent");
        f_city=getIntent().getStringExtra("f_city");
        f_description=getIntent().getStringExtra("f_description");
        f_contact=getIntent().getStringExtra("mobile_number");

        Glide.with(DisplayFur.this).load(image1).into(img1);
        Glide.with(DisplayFur.this).load(image2).into(img2);
        Glide.with(DisplayFur.this).load(image3).into(img3);
        name.setText(f_name);
        rent.setText(f_rent);
        city.setText(f_city);
        contact.setText(f_contact);
        description.setText(f_description);

    }
}
