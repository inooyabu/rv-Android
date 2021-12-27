package com.example.rv_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
//    public static final Integer EXTRA_PHOTO = Integer.valueOf("extra_photo");
    public  static final String EXTRA_PHOTO = ("extra_photo");
    public static final String EXTRA_ADDRESS = "extra_address";
    public static final String EXTRA_DESCRIPTION = "extra_description";

    TextView tvName, tvAddress, tvDescription;
    ImageView imgPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detail");

        tvName = findViewById(R.id.tv_detailName);
        tvDescription = findViewById(R.id.tv_detailDescription);
        tvAddress = findViewById(R.id.tv_detailAddress);
        imgPhoto = findViewById(R.id.imageView_detailTourism);

        int getPhoto = getIntent().getIntExtra(EXTRA_PHOTO, 0);

        tvName.setText(getIntent().getStringExtra(EXTRA_NAME));
        tvAddress.setText(getIntent().getStringExtra(EXTRA_ADDRESS));
        tvDescription.setText(getIntent().getStringExtra(EXTRA_DESCRIPTION));

        Glide.with(this)
                .load(getPhoto)
                .apply(new RequestOptions().override(900, 900))
                .into(imgPhoto);


    }
}