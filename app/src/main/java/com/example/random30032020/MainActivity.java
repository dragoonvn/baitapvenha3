package com.example.random30032020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText mEdt_nhapso1, mEdt_nhapso2;
    Button mBtn_luuso, mBtn_nhaplai, mBtn_ngaunhien;
    TextView mTv_ketqua;

    ArrayList<Integer> mArryso;
    int mNhapso1, mNhapso2;
    Random mRandom;
    String mText_nhapso1, mText_nhapso2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdt_nhapso1 = findViewById(R.id.edt_nhapso1);
        mEdt_nhapso2 = findViewById(R.id.edt_nhapso2);
        mBtn_luuso = findViewById(R.id.btn_luuso);
        mBtn_ngaunhien = findViewById(R.id.btn_ngaunhien);
        mBtn_nhaplai = findViewById(R.id.btn_nhaplai);
        mTv_ketqua = findViewById(R.id.tv_ketqua);

        mArryso = new ArrayList<>();
        mBtn_luuso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArryso.clear();
                mText_nhapso1 = mEdt_nhapso1.getText().toString();
                mText_nhapso2 = mEdt_nhapso2.getText().toString();
                if (mText_nhapso1.equals("") || mText_nhapso2.equals("")) {
                    Toast.makeText(MainActivity.this, "Nhập chưa đử thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                mNhapso1 = Integer.parseInt(mText_nhapso1);
                mNhapso2 = Integer.parseInt(mText_nhapso2);
                if (mNhapso1 >= mNhapso2){
                    mNhapso2 = mNhapso1 +1 ;
                    mEdt_nhapso2.setText(mNhapso1+"");
                }
                for (int i = mNhapso1; i <= mNhapso2; i++) {
                    mArryso.add(i);
                }
                if (mArryso.size() > 1) {
                    mEdt_nhapso1.setEnabled(false);
                    mEdt_nhapso2.setEnabled(false);
                    mBtn_luuso.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Lưu sô thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Không có thông tin để lưu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBtn_nhaplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Đặt lại thành công", Toast.LENGTH_SHORT).show();
                mArryso.clear();
                mEdt_nhapso1.setText("");
                mEdt_nhapso1.setEnabled(true);
                mEdt_nhapso2.setText("");
                mEdt_nhapso2.setEnabled(true);
                mBtn_luuso.setEnabled(true);
                mTv_ketqua.setText("");
            }
        });

        mBtn_ngaunhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mArryso.size()>0) {
                    mRandom =new Random();
                    int index = mRandom.nextInt(mArryso.size());
                    int value = mArryso.get(index);
                    if (mArryso.size()==1){
                        mTv_ketqua.append(value+"");
                    }
                    else {
                        mTv_ketqua.append(value+" - ");
                    }
                    mArryso.remove(index);
                }
                else {
                    Toast.makeText(MainActivity.this, "Không còn số random", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
