package com.example.k_pos.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.k_pos.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingScreen extends AppCompatActivity {

    private OnBoardingAdapter onBoardingAdapter;
    private LinearLayout layoutOnBoardingIndicator;
    private MaterialButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);

        layoutOnBoardingIndicator = findViewById(R.id.layoutOnBoardingIndicator);
        btnNext = findViewById(R.id.btn_next);

        setupOnBoardingItems();

        //this is setup ViewPager2
        final ViewPager2 onBoardingViewPager = findViewById(R.id.onBoardingViewPager);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        setUpOnBoardingIndicator();
        setCurrentOnBoardingIndicator(0);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBoardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()) {
                    onBoardingViewPager.setCurrentItem(onBoardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                    finish();
                }
            }
        });

    }

    private void setupOnBoardingItems() {

        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem EasyandFast = new OnBoardingItem();
        EasyandFast.setTitle("Sederhana dan Cepat");
        EasyandFast.setDescription("Lakukan transaksi dengan\n" +
                "cepat, jangan biarkan pelanggan \n" +
                "anda menunggu lama dan bosan");
        EasyandFast.setImg(R.drawable.img);

        OnBoardingItem OnlineOrder = new OnBoardingItem();
        OnlineOrder.setTitle("Bisa menerima \n" +
                "pesanan online");
        OnlineOrder.setDescription("Terima pesanan online  dengan\n" +
                "mudah dan cepat.");
        OnlineOrder.setImg(R.drawable.img);

        OnBoardingItem HandelRaport = new OnBoardingItem();
        HandelRaport.setTitle("Rekap Laporan terlengkap");
        HandelRaport.setDescription("Dapatkan laporan lengkap\n" +
                " tentang perfoma usaha anda.");
        HandelRaport.setImg(R.drawable.img);

        onBoardingItems.add(EasyandFast);
        onBoardingItems.add(OnlineOrder);
        onBoardingItems.add(HandelRaport);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private void setUpOnBoardingIndicator() {
        ImageView[] indicator = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicator.length; i++) {
            indicator[i] = new ImageView(getApplicationContext());
            indicator[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboardingindicator_unactive
            ));
            indicator[i].setLayoutParams(layoutParams);
            layoutOnBoardingIndicator.addView(indicator[i]);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCurrentOnBoardingIndicator(int index) {
        int childCount = layoutOnBoardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnBoardingIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),
                                R.drawable.onboardingindicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),
                                R.drawable.onboardingindicator_unactive)
                );
            }
        }
        if (index == onBoardingAdapter.getItemCount() - 1) {
            btnNext.setText("Start");
        } else {
            btnNext.setText("Next");
        }
    }
}
