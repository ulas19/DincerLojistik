package com.ulas.dincerlojistik.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.ulas.dincerlojistik.Adapter.PdfAdapter;
import com.ulas.dincerlojistik.InterFace.OnPdfSelectedListener;
import com.ulas.dincerlojistik.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ActivityTebligatA extends AppCompatActivity implements OnPdfSelectedListener {
    private PdfAdapter pdfAdapter;
    private List<File> pdfList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebligat);

        runtimePermission();
    }

    private void runtimePermission() {
        Dexter.withContext(ActivityTebligatA.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        disPlayPdf();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(ActivityTebligatA.this, "Permission is Required!!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();

    }
    public ArrayList<File> findPdf(File file){
        ArrayList<File> fileArrayList=new ArrayList<>();
        File[] files = file.listFiles();
        for (File singleFile:files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                fileArrayList.addAll(findPdf(singleFile));
            }
            else {
                if (singleFile.getName().endsWith(".pdf")){
                    fileArrayList.add(singleFile);
                }
            }
        }
        return fileArrayList;
    }
    public void disPlayPdf(){
        recyclerView = findViewById(R.id.recyler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        pdfList = new ArrayList<>();
        pdfList.addAll(findPdf(Environment.getExternalStorageDirectory()));
        pdfAdapter =new PdfAdapter(this,pdfList,this);
        recyclerView.setAdapter(pdfAdapter);
    }

    @Override
    public void onPdfSelectedListener(File file) {
        startActivity(new Intent(ActivityTebligatA.this,DocumentActivity.class).
                putExtra("path",file.getAbsolutePath()));
    }
}