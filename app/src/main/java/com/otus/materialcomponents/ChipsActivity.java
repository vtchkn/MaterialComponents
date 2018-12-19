package com.otus.materialcomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import androidx.appcompat.app.AppCompatActivity;

public class ChipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chips);
        ChipGroup chipGroup = findViewById(R.id.chipGroup);

        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, int i) {
                Chip chip = chipGroup.findViewById(i);
                if (chip != null)
                    Toast.makeText(getApplicationContext(), "Chip is " + chip.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        Chip chip = findViewById(R.id.chip);
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Close is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
