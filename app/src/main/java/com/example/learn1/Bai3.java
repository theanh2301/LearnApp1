package com.example.learn1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Bai3 extends Fragment {

    private EditText editTextA3, editTextB3, editTextC3;
    private Button buttonCheckTriangle3;
    private TextView textViewResult3;

    public Bai3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bai3, container, false);

        editTextA3 = view.findViewById(R.id.editTextACheckTriangle);
        editTextB3 = view.findViewById(R.id.editTextBCheckTriangle);
        editTextC3 = view.findViewById(R.id.editTextCCheckTriangle);
        buttonCheckTriangle3 = view.findViewById(R.id.buttonCheckTriangle);
        textViewResult3 = view.findViewById(R.id.textViewResultCheckTriangle);

        buttonCheckTriangle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(editTextA3.getText().toString());
                double b = Double.parseDouble(editTextB3.getText().toString());
                double c = Double.parseDouble(editTextC3.getText().toString());

                if (isTriangle(a, b, c)) {
                    textViewResult3.setText("Đây là tam giác " + checkTriangleType(a, b, c));
                } else {
                    textViewResult3.setText("Không phải là tam giác");
                }
            }
        });

        return view;
    }

    private boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    private String checkTriangleType(double a, double b, double c) {
        if (a == b && b == c) {
            return "đều";
        } else if (a == b || b == c || a == c) {
            return "cân";
        } else if (a * a + b * b == c * c || b * b + c * c == a * a || a * a + c * c == b * b) {
            return "vuông";
        } else {
            return "thường";
        }
    }
}
