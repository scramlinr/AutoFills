package com.example.sog.autofills;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Auto_Fill extends ActionBarActivity {
    private static final int PICKFILE_RESULT_CODE = 1;
    TextView textFile;
    String filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto__fill);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_auto__fill, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

        public void onClickButtonGetFile(View v){
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("file/*");
            startActivityForResult(intent,PICKFILE_RESULT_CODE);
        }
    public void onClickGenerate(View v) throws IOException{

        File file = new File(filePath);
        AutoFillCalc fillTime = new AutoFillCalc(file,filePath);
        fillTime.writeFile();
        TextView text = (TextView)findViewById(R.id.textView);
        text.setText("File Generated");

        String textThis = "Hello_World";
        String fileName = "jump.txt";
        FileOutputStream outputStream;


        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
           String prn = outputStream.toString();
            outputStream.write(fileName.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


protected void onActivityResult(int requestCode, int resultCode, Intent data){
        // TODO Auto-generated method stub
        switch(requestCode){
        case PICKFILE_RESULT_CODE:
        if(resultCode==RESULT_OK){
        filePath=data.getData().getPath();
        }
        break;

        }

        }
};




