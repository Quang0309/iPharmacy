package com.example.quang.ipharmacy;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String LOCALE_KEY = "localekey";
    private static final String HINDI_LOCALE = "vi";
    private static final String ENGLISH_LOCALE = "en_US";
    private static final String LOCALE_PREF_KEY = "localePref";
    private Locale locale;
    Button btnScan;
    Button btnLang;
    RadioButton btnEng;
    RadioButton btnViet;
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLanguage();
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        addPermissCamera();
        //SharedPreferences sp = getSharedPreferences(LOCALE_PREF_KEY, MODE_PRIVATE);
       // String localeString = sp.getString(LOCALE_KEY, ENGLISH_LOCALE);


    }

    private void loadLanguage() {
        Resources resources = getResources();
        SharedPreferences sharedPreferences = getSharedPreferences("localePref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.getString(LOCALE_KEY, ENGLISH_LOCALE).equals(HINDI_LOCALE))
        {
            locale = new Locale(HINDI_LOCALE);
            editor.putString(LOCALE_KEY, HINDI_LOCALE);
        }
        else
        {
            locale = new Locale(ENGLISH_LOCALE);
            editor.putString(LOCALE_KEY, ENGLISH_LOCALE);
        }
        editor.apply();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration,
                getBaseContext().getResources().getDisplayMetrics());
    }

    private void addEvents() {
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ScanCodeActivity.class);
                startActivity(intent);
            }
        });
        btnLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final View dialogView = View.inflate(MainActivity.this,R.layout.language_layout,null);
                final Dialog dialog = new Dialog(MainActivity.this);
               // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.language_layout);
               final View dialogView = dialog.findViewById(R.id.dialog);
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


                btnEng = dialog.findViewById(R.id.btnEng);
                btnViet = dialog.findViewById(R.id.btnViet);
                btnOK = dialog.findViewById(R.id.btnOK);

                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        revealShow(dialogView, true, null);
                        SharedPreferences sharedPreferences = getSharedPreferences("localePref", MODE_PRIVATE);
                        if(sharedPreferences.getString(LOCALE_KEY, ENGLISH_LOCALE).equals(HINDI_LOCALE))
                            btnViet.setChecked(true);
                        else
                            btnEng.setChecked(true);
                    }
                });

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Resources resources = getResources();
                        SharedPreferences sharedPreferences = getSharedPreferences("localePref", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                       if (btnEng.isChecked())
                       {
                           //locale = new Locale(ENGLISH_LOCALE);
                           editor.putString(LOCALE_KEY, ENGLISH_LOCALE);

                       }
                       else
                       {
                           //locale = new Locale(HINDI_LOCALE);
                           editor.putString(LOCALE_KEY, HINDI_LOCALE);
                       }
                        editor.apply();

                      /*  Configuration configuration = resources.getConfiguration();
                        configuration.setLocale(locale);
                        getBaseContext().getResources().updateConfiguration(configuration,
                                getBaseContext().getResources().getDisplayMetrics());*/

                        recreate();
                        //Toast.makeText(MainActivity.this,"nice",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }



    private void addPermissCamera() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);

        }
    }


    private void addControls() {


        btnScan = findViewById(R.id.btnScan);
        btnLang = findViewById(R.id.btnLang);


    }

    private void revealShow(final View dialogView, boolean b, final Dialog dialog) {

       // final View view = dialogView.findViewById(R.id.dialog);

        int w = dialogView.getWidth();
        int h = dialogView.getHeight();

        int endRadius = (int) Math.hypot(w, h)+300;
        //Toast.makeText(this,Integer.toString(endRadius),Toast.LENGTH_LONG).show();
        int cx = 719;//(int) (btnScan.getX() + (btnScan.getWidth()/2));
        int cy = 1294;//(int) (btnScan.getY()+ btnScan.getHeight() + 56);
       // Toast.makeText(this,Integer.toString(cx),Toast.LENGTH_SHORT).show();
      //  Toast.makeText(this,Integer.toString(cy),Toast.LENGTH_SHORT).show();

        if(b){
            Animator revealAnimator = ViewAnimationUtils.createCircularReveal(dialogView, cx,cy, 0, endRadius);

           // dialogView.setVisibility(View.VISIBLE);
            revealAnimator.setDuration(500);
            revealAnimator.start();

        }

    }

}
