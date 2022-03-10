package com.example.multiplespinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        distirictAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set the adapter to the spinner to populate the district Spinner
        districtSpinner.setAdapter(distirictAdapter);
        //When any item of the districtSpinner uis selected
            districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                 thanaSpinner =findViewById(R.id.spinner_thana);

                 selectDistrict = districtSpinner.getSelectedItem().toString();


                    int parentID = parent.getId();
                    if (parentID == R.id.spinner_district){
                        switch (selectDistrict) {
                            case "Select Your district" : thanaAdapter =ArrayAdapter.createFromResource(parent.getContext(),
                                  R.array.array_default_thana, R.layout.spinner_layout );
                            break;

                            case "Dhaka" : thanaAdapter =ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.array_dhaka_thana, R.layout.spinner_layout );
                                break;
                            case "Chandpur" : thanaAdapter =ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.array_chandpur_thana, R.layout.spinner_layout );
                            break;
                            case "Comilla" : thanaAdapter =ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.array_comilla_thana, R.layout.spinner_layout );
                                break;
                            default: break;

                        }
                        thanaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        thanaSpinner.setAdapter(thanaAdapter);

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
    }
}