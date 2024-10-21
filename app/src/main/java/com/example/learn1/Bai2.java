package com.example.learn1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai2 extends Fragment {

    private EditText editTextNumber2;
    private Button buttonCheckPrime2;
    private TextView textViewResult2;

    public Bai2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bai2, container, false);

        editTextNumber2 = view.findViewById(R.id.editTextNumberCheckPrime);
        buttonCheckPrime2 = view.findViewById(R.id.buttonCheckPrime);
        textViewResult2 = view.findViewById(R.id.textViewResultCheckPrime);

        buttonCheckPrime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(editTextNumber2.getText().toString());
                if (isPrime(number)) {
                    textViewResult2.setText(number + " là số nguyên tố");
                } else {
                    textViewResult2.setText(number + " không phải là số nguyên tố");
                }
            }
        });

        return view;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}