package com.ulas.dincerlojistik.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.ulas.dincerlojistik.R;

import java.io.File;

public class DocumentActivity extends AppCompatActivity {
    String filepath="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        PDFView pdfView = findViewById(R.id.pdfView);
        filepath=getIntent().getStringExtra("path");

        File file= new File(filepath);
        Uri path = Uri.fromFile(file);
        pdfView.fromUri(path).load();
    }
}