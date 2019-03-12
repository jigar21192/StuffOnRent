package com.example.viral.stuffonrent;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class UploadCostume extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final int CAMERA_REQUEST = 1888;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String KEY_Email = "email";
    public static final String ID = "id";
    SharedPreferences sharedPreferences;

    ImageView img1;
    ImageView img2;
    ImageView img3;

    ProgressDialog pd;

    long imagename1,imagename2,imagename3;

    Spinner spinner;

    Bitmap photo1,photo2,photo3;

    EditText item_name, item_price, city, item_description;

    String id,itemname, itemprice, location, description, spinnervalue;

    String url="https://chauhanviral36.000webhostapp.com/insert_costume.php";

    String[] type = {"Select", "Navratri Special", "Wedding Special"};

    Button upload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_costume);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        id= sharedPreferences.getString("id","");
        pd=new ProgressDialog(UploadCostume.this);
        pd.setMessage("Loading");
        pd.setCancelable(false);

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

                pd.show();

                itemname = item_name.getText().toString();
                itemprice = item_price.getText().toString();
                location = city.getText().toString();
                description = item_description.getText().toString();

                if(img1.getTag()!="tt"){

                    pd.dismiss();
                    Toast.makeText(UploadCostume.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }
                else if(img2.getTag()!="tt"){

                    pd.dismiss();
                    Toast.makeText(UploadCostume.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }
                else if(img3.getTag()!="tt"){

                    pd.dismiss();
                    Toast.makeText(UploadCostume.this, "Image Is Required", Toast.LENGTH_SHORT).show();
                }

                else if (spinnervalue.equals("Select")){

                    pd.dismiss();
                    Toast.makeText(UploadCostume.this, "Please Select Costume Type", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(itemname)){

                    pd.dismiss();
                    Toast.makeText(UploadCostume.this, "Item Name Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(itemprice)){

                    pd.dismiss();
                    Toast.makeText(UploadCostume.this, "Item Rent Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(location)){

                    pd.dismiss();
                    Toast.makeText(UploadCostume.this, "Your Location Is Required", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(description)){

                    pd.dismiss();
                    Toast.makeText(UploadCostume.this, "Please Enter Some Description For Item", Toast.LENGTH_SHORT).show();
                }

                else {

                    VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST,url,
                            new Response.Listener<NetworkResponse>() {
                                @Override
                                public void onResponse(NetworkResponse response) {

                                    try {
                                        JSONObject obj = new JSONObject(new String(response.data));
                                        String ss = obj.getString("success");
                                        Log.e("ResObj", ">>>>" + ss);
                                        if (ss.equals("success")) {

                                            pd.dismiss();
                                            Toast.makeText(getApplicationContext(), "Item Upload SuccessFully", Toast.LENGTH_SHORT).show();

                                            Intent intent = new Intent(UploadCostume.this,HomeActivity.class);
                                            startActivity(intent);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                    pd.dismiss();
                                    Toast.makeText(UploadCostume.this, "Connection Problem", Toast.LENGTH_SHORT).show();                                }
                            }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("id", id);
                            params.put("itemname", itemname);
                            params.put("location", location);
                            params.put("category",spinnervalue);
                            params.put("rent_price", itemprice);
                            params.put("details", description);
                            return params;
                        }


                        @Override
                        protected Map<String, DataPart> getByteData() {
                            Map<String, DataPart> params = new HashMap<>();
                           /*  imagename1 = System.currentTimeMillis();
                            imagename2 = System.currentTimeMillis();
                             imagename3 = System.currentTimeMillis();*/
                            params.put("image", new DataPart(imagename1 + ".png", getFileDataFromDrawable1(photo1)));
                            params.put("image1", new DataPart(imagename2 + ".png", getFileDataFromDrawable2(photo2)));
                            params.put("image2", new DataPart(imagename3 + ".png", getFileDataFromDrawable3(photo3)));
                            return params;
                        }
                    };

                    //adding the request to volley
                    Volley.newRequestQueue(UploadCostume.this).add(volleyMultipartRequest);
                    volleyMultipartRequest .setRetryPolicy(new DefaultRetryPolicy(
                            10000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                }

            }
        });

    }

    public byte[] getFileDataFromDrawable1(Bitmap photo1) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        photo1.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    public byte[] getFileDataFromDrawable2(Bitmap photo2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        photo2.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    public byte[] getFileDataFromDrawable3(Bitmap photo3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        photo3.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                photo1 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imagename1 = System.currentTimeMillis();

                //Setting image to ImageView
                img1.setImageBitmap(photo1);

                img1.setTag("tt");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                photo2 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imagename2 = System.currentTimeMillis();

                //Setting image to ImageView
                img2.setImageBitmap(photo2);

                img2.setTag("tt");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (requestCode == 3 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                photo3 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imagename3 = System.currentTimeMillis();

                //Setting image to ImageView
                img3.setImageBitmap(photo3);

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
