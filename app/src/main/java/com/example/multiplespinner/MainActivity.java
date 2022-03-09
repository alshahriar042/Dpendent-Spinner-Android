package com.example.multiplespinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String selectDistrict, selectThana;
    private TextView TvDistrictSpinner, TvThanaSpinne;
    private Spinner districtSpinner, thanaSpinner;
    private ArrayAdapter<CharSequence> distirictAdapter, thanaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dist Spinner Initialisation
        districtSpinner = findViewById(R.id.spinner_district);

        //Populate ArrayAdapter using string array and a spinner layout that we will define
        distirictAdapter =ArrayAdapter.createFromResource(this,R.array.array_district,R.layout.spinner_layout);

        // Specify the layout to use when the list of choices appear
        distirictAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtSpinner.setAdapter(distirictAdapter); //Set the adapter to the spinner to populate the State Spinner

    }
}