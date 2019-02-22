package com.example.viral.stuffonrent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class UploadVehicles extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int CAMERA_REQUEST = 1888;

    ImageView img1;
    ImageView img2;
    ImageView img3;

    Spinner spinner;

    Bitmap photo1,photo2,photo3;

    EditText item_name, item_price, company_name, city, item_description;

    String itemname, itemprice, companyname, location, description, spinnervalue;

    String[] type = {"Select", "Two Wheeler", "Four Wheeler"};

    Button upload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_vehicles);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        spinner = findViewById(R.id.spinner);
        item_name = findViewById(R.id.item_name);
        company_name = findViewById(R.id.company_name);
        item_price = findViewById(R.id.item_price);
        city = findViewById(R.id.city);
        item_description = findViewById(R.id.item_description);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,type);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        upload = findViewById(R.id.upload);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), 2);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), 3);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemname = item_name.getText().toString();
                itemprice = item_price.getText().toString();
                companyname = company_name.getText().toString();
                location = city.getText().toString();
                description = item_description.getText().toString();

                if(img1.getTag()!="tt"){

                    Toast.makeText(UploadVehicles.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }
                else if(img2.getTag()!="tt"){

                    Toast.makeText(UploadVehicles.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }
                else if(img3.getTag()!="tt"){

                    Toast.makeText(UploadVehicles.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }

                else if (spinnervalue.equals("Select")){

                    Toast.makeText(UploadVehicles.this, "Please Select Vehicles Type", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(itemname)){

                    Toast.makeText(UploadVehicles.this, "Item Name Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(itemprice)){

                    Toast.makeText(UploadVehicles.this, "Item Rent Is Required", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(companyname)){

                    Toast.makeText(UploadVehicles.this, "Company Name Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(location)){

                    Toast.makeText(UploadVehicles.this, "Your Location Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(description)){

                    Toast.makeText(UploadVehicles.this, "Please Enter Some Description For Item", Toast.LENGTH_SHORT).show();
                }

                else {

                    Toast.makeText(UploadVehicles.this, "Item Upload Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
                img1.setImageBitmap(bitmap);

                img1.setTag("tt");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
                img2.setImageBitmap(bitmap);

                img2.setTag("tt");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (requestCode == 3 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
                img3.setImageBitmap(bitmap);

                img3.setTag("tt");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        spinnervalue= type[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
