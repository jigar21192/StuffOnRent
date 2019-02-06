package com.example.viral.stuffonrent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class UploadCostume extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final int CAMERA_REQUEST = 1888;

    ImageView img1;
    ImageView img2;
    ImageView img3;

    Spinner spinner;

    Bitmap photo1,photo2,photo3;

    EditText item_name, item_price, city, item_description;

    String itemname, itemprice, location, description, spinnervalue;

    String[] type = {"Select", "Navratri Special", "Wedding Special"};

    Button upload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_costume);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        spinner = findViewById(R.id.spinner);
        item_name = findViewById(R.id.item_name);
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
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 1);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 2);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 3);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemname = item_name.getText().toString();
                itemprice = item_price.getText().toString();
                location = city.getText().toString();
                description = item_description.getText().toString();

                if(img1.getTag()!="tt"){

                    Toast.makeText(UploadCostume.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }
                else if(img2.getTag()!="tt"){

                    Toast.makeText(UploadCostume.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }
                else if(img3.getTag()!="tt"){

                    Toast.makeText(UploadCostume.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }

                else if (spinnervalue.equals("Select")){

                    Toast.makeText(UploadCostume.this, "Please Select Vehicles Type", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(itemname)){

                    Toast.makeText(UploadCostume.this, "Item Name Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(itemprice)){

                    Toast.makeText(UploadCostume.this, "Item Rent Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(location)){

                    Toast.makeText(UploadCostume.this, "Your Location Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(description)){

                    Toast.makeText(UploadCostume.this, "Please Enter Some Description For Item", Toast.LENGTH_SHORT).show();
                }

                else {

                    Toast.makeText(UploadCostume.this, "Item Upload Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            photo1 = (Bitmap) data.getExtras().get("data");
            img1.setTag("tt");
            img1.setImageBitmap(photo1);
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {
            photo2 = (Bitmap) data.getExtras().get("data");
            img2.setTag("tt");
            img2.setImageBitmap(photo2);
        }
        if (requestCode == 3 && resultCode == RESULT_OK) {
            photo3 = (Bitmap) data.getExtras().get("data");
            img3.setTag("tt");
            img3.setImageBitmap(photo3);
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
