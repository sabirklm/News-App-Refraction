package com.quapps.refraction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> newsHeadings;
    ArrayList<String> newsBody;
    MyOwnAdapter myOwnAdapter;
    int size=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.myRecycler);
        newsHeadings=new ArrayList<>();
        newsBody=new ArrayList<>();
        newsHeadings.add("TRP Scam Case: Republic TV and Aranb Goswami Move Bombai High Court Seeking Stay of Further");
        newsBody.add("ARG outliner Media Private Limited ( Which own Republic TV ) and Aranb Goswami have approach...");
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<size;i++){
                    newsHeadings.add("Loading "+i);
                    newsBody.add("Loading "+i);
                }
            }
        });
        myOwnAdapter=new MyOwnAdapter(this,newsHeadings,newsBody);
        recyclerView.setAdapter(myOwnAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
