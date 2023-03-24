package com.example.mycalculator;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.aidlserver.IAIDLCalculateInterface;

public class MainActivity extends AppCompatActivity {
    private TextView perhitungan, hasil;
    private Button btnClear, btnKurung, btnPersen, btnBagi, btnTujuh, btnDelapan, btnSembilan, btnKali, btnEmpat, btnLima, btnEnam, btnKurang, btnSatu, btnDua, btnTiga, btnTambah, btnMinus, btnNol, btnKoma, btnSamadengan;
    private ImageButton btnBackspace;
    private String stringPerhitungan = "";
    private String stringHasil = "";
    private Boolean kurungFlag = false;
    private Calculate calculate = new Calculate();
    private IAIDLCalculateInterface iAIDLCalculateService;
    private ServiceConnection serviceCon ;
    private void inisialisasi(){
        perhitungan = findViewById(R.id.perhitungan);
        hasil = findViewById(R.id.hasil);
        btnClear = findViewById(R.id.clear);
        btnKurung = findViewById(R.id.kurung);
        btnPersen = findViewById(R.id.persen);
        btnBagi = findViewById(R.id.bagi);
        btnTujuh = findViewById(R.id.tujuh);
        btnDelapan = findViewById(R.id.delapan);
        btnSembilan = findViewById(R.id.sembilan);
        btnKali = findViewById(R.id.kali);
        btnEmpat = findViewById(R.id.empat);
        btnLima = findViewById(R.id.lima);
        btnEnam = findViewById(R.id.enam);
        btnKurang = findViewById(R.id.kurang);
        btnSatu = findViewById(R.id.satu);
        btnDua = findViewById(R.id.dua);
        btnTiga = findViewById(R.id.tiga);
        btnTambah = findViewById(R.id.tambah);
        btnMinus = findViewById(R.id.minus);
        btnNol = findViewById(R.id.nol);
        btnKoma = findViewById(R.id.koma);
        btnSamadengan = findViewById(R.id.samadengan);
        btnBackspace = findViewById(R.id.btnBackspace);
    }
    private void set_text(){
        try {
            stringHasil = String.valueOf(iAIDLCalculateService.doCalculate(stringPerhitungan));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        if(Double.parseDouble(stringHasil) % 1  == 0){
            stringHasil = String.valueOf((int) Double.parseDouble(stringHasil));
        }
        hasil.setText(stringHasil);
    }
    private void btnSetOnClick(){
        //        Button Clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = "";
                perhitungan.setText("0");
                hasil.setText("0");
                kurungFlag = false;
            }
        });

//        Button satu
        btnSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "1";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button dua
        btnDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "2";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button tiga
        btnTiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "3";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button empat
        btnEmpat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "4";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button lima
        btnLima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "5";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button enam
        btnEnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "6";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button tujuh
        btnTujuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "7";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button delapan
        btnDelapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "8";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button sembilan
        btnSembilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "9";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button nol
        btnNol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "0";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button tambah
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "+";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button kurang
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "-";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button kali
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "x";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button bagi
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan + "/";
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button kurung
        btnKurung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kurungFlag == true){
                    stringPerhitungan = stringPerhitungan + ")";
                    kurungFlag = false;
                }else {
                    stringPerhitungan = stringPerhitungan + "(";
                    kurungFlag = true;
                }
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button backspace
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPerhitungan = stringPerhitungan.substring(0,stringPerhitungan.length()-1);
                perhitungan.setText(stringPerhitungan);
            }
        });
//        Button samadengan
        btnSamadengan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_text();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceCon = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                iAIDLCalculateService = IAIDLCalculateInterface.Stub.asInterface(iBinder);
                Log.i(TAG, "onServiceConnected : CONNECTED");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        Intent intent = new Intent("AIDLCalculateService");
        intent.setPackage("com.example");
        bindService(intent,serviceCon,BIND_AUTO_CREATE);
        inisialisasi();
        btnSetOnClick();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}

