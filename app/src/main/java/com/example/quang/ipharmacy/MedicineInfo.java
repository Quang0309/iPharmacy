package com.example.quang.ipharmacy;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.quang.ipharmacy.model.Medicine;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MedicineInfo extends AppCompatActivity {
    String ID;
    DatabaseReference databaseReference;
    FirebaseStorage storage;
    StorageReference storageReference;
    Medicine medicine;
    EditText txtInfoName,txtInfoLastModify,txtQuantity;
    ImageView imgInfo;
    Button btnSave;
    ProgressDialog dialog;
    AlertDialog.Builder alertDialog;
    AlertDialog dialog2;
    Uri file;
    UploadTask uploadTask;
    byte[] bytes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_info);
        addControls();
        addEvents();
        init();
        getDataFromIntent();
        //startAnimation();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtInfoName.getText().toString().isEmpty()||txtQuantity.getText().toString().isEmpty()) {
                    Toast.makeText(MedicineInfo.this,"Please input name and quantity of the product",Toast.LENGTH_LONG).show();
                    return;
                }

                if(txtInfoLastModify.getText().toString().isEmpty()) {
                    Toast.makeText(MedicineInfo.this,"The date modify can not be empty",Toast.LENGTH_LONG).show();
                    return;
                }
                dialog.setMessage("Saving");
                dialog.show();
                String name = txtInfoName.getText().toString();
                String URL = "";
                int quantity = Integer.parseInt(txtQuantity.getText().toString());


                try {
                    if(file!=null) {
                        Bitmap bitmap = getThumbnail(file);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        bytes = stream.toByteArray();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(bytes!=null)
                {
                    medicine = new Medicine(name,URL,quantity,txtInfoLastModify.getText().toString());
                    StorageReference riversRef = storageReference.child(ID+file.getLastPathSegment());
                    uploadTask = riversRef.putBytes(bytes);
                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(MedicineInfo.this,"looppppp",Toast.LENGTH_LONG).show();
                            Log.e("Here","Before");
                           medicine.setImage(String.valueOf(taskSnapshot.getDownloadUrl()));
                            Log.e("Here","After");
                            Log.e("Here", String.valueOf(medicine.getImage()));
                            databaseReference.child(ID).setValue(medicine);
                            Log.e("Here","Forever");
                            dialog.dismiss();
                            finish();
                        }
                    });


                }
                else if (medicine!=null)
                {
                    medicine.setQuantity(Integer.parseInt(txtQuantity.getText().toString()));
                    medicine.setName(txtInfoName.getText().toString());
                    medicine.setLastModify(txtInfoLastModify.getText().toString());
                    databaseReference.child(ID).setValue(medicine);
                    dialog.dismiss();
                    finish();
                }
                else
                {
                    Toast.makeText(MedicineInfo.this,"Please upload an image of the product",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }


            }
        });
        imgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                file = Uri.fromFile(getOutputMediaFile());
                intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                startActivityForResult(intent, 100);
            }
        });
    }

    public  Bitmap getThumbnail(Uri uri) throws FileNotFoundException, IOException {

        InputStream input = this.getContentResolver().openInputStream(uri);

        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither=true;//optional
        onlyBoundsOptions.inPreferredConfig=Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();

        if ((onlyBoundsOptions.outWidth == -1) || (onlyBoundsOptions.outHeight == -1)) {
            return null;
        }

        int originalSize = (onlyBoundsOptions.outHeight > onlyBoundsOptions.outWidth) ? onlyBoundsOptions.outHeight : onlyBoundsOptions.outWidth;

        double ratio = (originalSize > 400) ? (originalSize / 400) : 1.0;

        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = getPowerOfTwoForSampleRatio(ratio);
        bitmapOptions.inDither = true; //optional
        bitmapOptions.inPreferredConfig=Bitmap.Config.ARGB_8888;//
        input = this.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();
        return bitmap;
    }

    private static int getPowerOfTwoForSampleRatio(double ratio){
        int k = Integer.highestOneBit((int)Math.floor(ratio));
        if(k==0) return 1;
        else return k;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100)
        {
            if(resultCode==RESULT_OK)
                imgInfo.setImageURI(file);
        }
    }

    private File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }

    private void addControls() {
        txtInfoName = findViewById(R.id.txtInfoName);
        txtInfoLastModify =findViewById(R.id.txtInfoLastModify);
        txtQuantity = findViewById(R.id.txtQuantity);
        imgInfo = findViewById(R.id.imgInfo);
        btnSave = findViewById(R.id.btnSave);
    }

    private void loadData() {
        txtInfoName.setText(medicine.getName());
        txtQuantity.setText(Integer.toString(medicine.getQuantity()));
        txtInfoLastModify.setText( medicine.getLastModify());
        storageReference = storage.getReferenceFromUrl(medicine.getImage());
        Glide.with(getApplicationContext()).using(new FirebaseImageLoader()).load(storageReference).into(imgInfo);
    }
    private void loadDate() // ko co trong data thi nhap vo, last modify la ngay hom nay
    {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(date);
        txtInfoLastModify.setText(currentDate);
    }
    private void init() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();

        storageReference = storage.getReference();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.show();
    }

    public void getDataFromIntent() {
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()) //loading medicine from database
                {                                                       // if exists.
                    if (snapshot.getKey().equals(ID)) {
                        //Toast.makeText(MedicineInfo.this,"helloooooo",Toast.LENGTH_LONG).show();
                        Medicine temp = snapshot.getValue(Medicine.class);
                        medicine = temp;
                        loadData();
                    }
                  // Toast.makeText(MedicineInfo.this,snapshot.getKey(),Toast.LENGTH_LONG).show();
                }
                if(medicine==null)
                {
                    alertDialog = new AlertDialog.Builder(MedicineInfo.this);
                    alertDialog.setMessage("Please input the following information");
                    alertDialog.setTitle("This is a new product");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialog2.dismiss();
                        }
                    });
                    dialog2 = alertDialog.create();
                    dialog2.show();
                    loadDate();
                }
                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
   /* private void startAnimation()
    {
        float start,end1,end2;
        start = findViewById(R.id.relativeLayout).getHeight();
        Toast.makeText(this,Float.toString(start),Toast.LENGTH_LONG).show();
        end1 = findViewById(R.id.imgbtnName).getTop();
        Toast.makeText(this,Float.toString(end1),Toast.LENGTH_LONG).show();
        end2 =findViewById(R.id.txtInfoName).getTop();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.imgbtnName),"y",end1,start).setDuration(3000);
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(findViewById(R.id.txtInfoName),"y",start,end2).setDuration(3000);
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        objectAnimator.start();
        objectAnimator1.start();
    }*/
}
