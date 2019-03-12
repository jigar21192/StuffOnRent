package com.example.viral.stuffonrent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DisplayCostu extends AppCompatActivity {
    ImageView img1,img2,img3;

    TextView name,rent,category,city,contact,description;

    String image1,image2,image3,c_name,c_rent,c_city,c_description,c_contact,c_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_costu);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        name=findViewById(R.id.name);
        category=findViewById(R.id.category);
        rent=findViewById(R.id.rent);
        city=findViewById(R.id.city);
        contact=findViewById(R.id.contact);
        description=findViewById(R.id.description);

        image1=getIntent().getStringExtra("image1");
        image2=getIntent().getStringExtra("image2");
        image3=getIntent().getStringExtra("image3");
        c_category=getIntent().getStringExtra("c_category");
        c_name=getIntent().getStringExtra("c_name");
        c_rent=getIntent().getStringExtra("c_rent");
        c_city=getIntent().getStringExtra("c_city");
        c_description=getIntent().getStringExtra("c_description");
        c_contact=getIntent().getStringExtra("mobile_number");

        Glide.with(DisplayCostu.this).load(image1).into(img1);
        Glide.with(DisplayCostu.this).load(image2).into(img2);
        Glide.with(DisplayCostu.this).load(image3).into(img3);
        category.setText(c_category);
        name.setText(c_name);
        rent.setText(c_rent);
        city.setText(c_city);
        contact.setText(c_contact);
        description.setText(c_description);

    }
}
