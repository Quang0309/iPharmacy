package com.example.quang.ipharmacy;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    TextView txtBarcode;
    Button btnScan;
    IntentIntegrator intentIntegrator; // Open source
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        addPermission();

    }

    private void addPermission() {
        if (checkSelfPermission(Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]{Manifest.permission.CAMERA},123);
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},124);

        return;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null)
        {
            if(result.getContents()!=null)
            {
                Intent intent = new Intent(MainActivity.this,MedicineInfo.class);
                intent.putExtra("ID",result.getContents());
                startActivity(intent);
            }
            else
                txtBarcode.setText("Can not scan");
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    private void addEvents() {
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentIntegrator.initiateScan();
            }
        });

    }

    private void addControls() {
        txtBarcode = findViewById(R.id.txtBarcode);
        btnScan = findViewById(R.id.btnScan);
        intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setPrompt("Scaning");
        intentIntegrator.setCameraId(Camera.CameraInfo.CAMERA_FACING_BACK);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(false);

    }

}
