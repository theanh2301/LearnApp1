package com.example.learn1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4 extends Fragment {

    private EditText editTextA4, editTextB4, editTextC4;
    private Button buttonSolve4;
    private TextView textViewResult4;

    public Bai4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bai4, container, false);

        editTextA4 = view.findViewById(R.id.editTextASolve);
        editTextB4 = view.findViewById(R.id.editTextBSolve);
        editTextC4 = view.findViewById(R.id.editTextCSolve);
        buttonSolve4 = view.findViewById(R.id.buttonSolve);
        textViewResult4 = view.findViewById(R.id.textViewResultSolve);

        buttonSolve4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(editTextA4.getText().toString());
                double b = Double.parseDouble(editTextB4.getText().toString());
                double c = Double.parseDouble(editTextC4.getText().toString());

                String result = solveQuadraticEquation(a, b, c);
                textViewResult4.setText(result);
            }
        });

        return view;
    }

    private String solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                return (c == 0) ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm";
            } else {
                return "Phương trình có một nghiệm: " + (-c / b);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                return "Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                return "Phương trình có nghiệm kép: x = " + x;
            } else {
                return "Phương trình vô nghiệm";
            }
        }
    }
}