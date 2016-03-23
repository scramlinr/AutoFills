package com.example.sog.autofills;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sog on 3/21/2015.
 */
public class AutoFillCalc {
    File info;
    String filePath;

    public AutoFillCalc(File info, String filePath) {
        this.info = info;
        this.filePath = filePath;
    }

    public void writeFile() throws IOException {

        String text = "Hello_World";
        String fileName = "myfile";
        FileOutputStream outputStream;
        File file = new File(fileName);


    }

}

