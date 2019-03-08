package com.example.viral.stuffonrent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class Upload extends AppCompatActivity {

    CardView pac_card;
    CardView furn_card;
    CardView appli_card;
    CardView vehi_card;
    CardView costume_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        pac_card = findViewById(R.id.pac_card);
        furn_card = findViewById(R.id.furn_card);
        appli_card = findViewById(R.id.appli_card);
        vehi_card = findViewById(R.id.vehi_card);
        costume_card = findViewById(R.id.costume_card);

        pac_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Upload.this,UploadPackages.class);
                startActivity(intent);
                finish();
            }
        });

        furn_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Upload.this,UploadFurniture.class);
                startActivity(intent);
                finish();
            }
        });

        appli_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Upload.this,UploadAppliances.class);
                startActivity(intent);
                finish();
            }
        });

        vehi_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Upload.this,UploadVehicles.class);
                startActivity(intent);
                finish();
            }
        });

        costume_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Upload.this,UploadCostume.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
