package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit_cm;
    EditText edit_kg;

    Button btnCal;

    TextView txt_result_bmi;
    TextView txt_result_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_cm = findViewById(R.id.edit_cm);
        edit_kg = findViewById(R.id.edit_kg);
        btnCal = findViewById(R.id.btnCal);
        txt_result_bmi = findViewById(R.id.txt_result_bmi);
        txt_result_msg = findViewById(R.id.txt_result_msg);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bringCm = edit_cm.getText().toString();
                String bringKg = edit_kg.getText().toString();


                if (bringCm.equals("")) {
                    Toast.makeText(getApplicationContext(), "키를 입력해 주세요", Toast.LENGTH_SHORT).show();
                } else if (bringKg.equals("")) {
                    Toast.makeText(getApplicationContext(), "몸무게를 입력해 주세요", Toast.LENGTH_SHORT).show();
                } else {

                    int changeCm = Integer.parseInt(bringCm);
                    int changeKg = Integer.parseInt(bringKg);

                    double resultBmi = changeKg / ((changeCm * 0.01) * (changeCm * 0.01));
                    Toast.makeText(getApplicationContext(), "bmi 결과값은 == " + resultBmi, Toast.LENGTH_SHORT).show();

                    int finalBmi = (int) resultBmi;
                    String resultMsg = "";

                    if (resultBmi >= 40) {
                        resultMsg = "고도비만";
                    } else if (resultBmi >= 30) {
                        resultMsg = "비만";
                    } else if (resultBmi >= 25) {
                        resultMsg = "과체중";
                    } else if (resultBmi >= 20) {
                        resultMsg = "정상";
                    } else {
                        resultMsg = "저체중";
                    }

                    txt_result_bmi.setText("BMI : " + finalBmi);
                    txt_result_msg.setText("결과는 " + resultMsg);
                }

            }
        });

//        btnCal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //첫번째는 키와 몸무게 값이 둘다 들어와 있는지 확인한다.
//                // bmi 계산 몸무게 / (키*0.01) * (키*0.01))
//                //결과를 if 문으로 체크하고 결과를 뿌려준다.
//
//
//
//            }
//        });

    }

    private void bmiCal() {
        int height = Integer.parseInt(edit_cm.getText().toString());
        int weight = Integer.parseInt(edit_kg.getText().toString());

        double bmi = weight / ((height * 0.01) * (height * 0.01));

    }
}

