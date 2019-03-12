package com.example.viral.stuffonrent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DisplayPac extends AppCompatActivity {

    ImageView img1,img2,img3;

    TextView name,rent,city,contact,description;

    String image1,image2,image3,p_name,p_rent,p_city,p_description,p_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pac);

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
        p_name=getIntent().getStringExtra("p_name");
        p_rent=getIntent().getStringExtra("p_rent");
        p_city=getIntent().getStringExtra("p_city");
        p_description=getIntent().getStringExtra("p_description");
        p_contact=getIntent().getStringExtra("mobile_number");

        Glide.with(DisplayPac.this).load(image1).into(img1);
        Glide.with(DisplayPac.this).load(image2).into(img2);
        Glide.with(DisplayPac.this).load(image3).into(img3);
        name.setText(p_name);
        rent.setText(p_rent);
        city.setText(p_city);
        contact.setText(p_contact);
        description.setText(p_description);
    }
}
