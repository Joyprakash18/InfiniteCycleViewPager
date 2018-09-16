package com.example.joyprakash.infinitecycleviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Integer> images = new ArrayList<>();
    List<String> names = new ArrayList<>();
    private Button mSetData;
    private Spinner emailId;
    ArrayAdapter<String> dataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSetData = findViewById(R.id.setData);
        emailId = findViewById(R.id.emailId);

        setData();
        final HorizontalInfiniteCycleViewPager infiniteCycleViewPager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        HorizontalPagerAdapter horizontalPagerAdapter = new HorizontalPagerAdapter(images,names,getBaseContext());
        infiniteCycleViewPager.setAdapter(horizontalPagerAdapter);
        infiniteCycleViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                emailId.setSelection(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
       emailId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (infiniteCycleViewPager.getCurrentItem() != i)
                   infiniteCycleViewPager.setCurrentItem(i);
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
    }

    private void setData() {
        names.add("abc@gmail.com");
        names.add("pqr@gmail.com");
        names.add("xyz@gmail.com");
        images.add(R.mipmap.ic_launcher_round);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher_round);
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emailId.setAdapter(dataAdapter);
//        images.add(R.mipmap.ic_launcher_round);
//        images.add(R.mipmap.ic_launcher_round);
    }
}