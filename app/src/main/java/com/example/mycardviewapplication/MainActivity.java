package com.example.mycardviewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    MyAdpterClass adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("RecyclerView Application");

        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        // recycler.setLayoutManager(new LinearLayoutManager(this));

        // LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        // recycler.setLayoutManager(layoutManager);

        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recycler.setLayoutManager(layoutManager);

        adpter = new MyAdpterClass(dataFit(),getApplicationContext());
        recycler.setAdapter(adpter);
    }

    public ArrayList<Model> dataFit()
    {
        ArrayList<Model> holder = new ArrayList<>();
        Model obj1 = new Model();
        obj1.setHeader("C Programming");
        obj1.setDescription("Desktop Programming");
        obj1.setImageName(R.drawable.c);
        holder.add(obj1);

        Model obj2 = new Model();
        obj2.setHeader("C++ Programming");
        obj2.setDescription("Desktop Programming");
        obj2.setImageName(R.drawable.cplusplus);
        holder.add(obj2);

        Model obj3 = new Model();
        obj3.setHeader("Python Programming");
        obj3.setDescription("Desktop Programming");
        obj3.setImageName(R.drawable.python);
        holder.add(obj3);

        Model obj4 = new Model();
        obj4.setHeader(".net Programming");
        obj4.setDescription("Software Framework");
        obj4.setImageName(R.drawable.net);
        holder.add(obj4);

        Model obj5 = new Model();
        obj5.setHeader("HTML");
        obj5.setDescription("HyperText Markup Language");
        obj5.setImageName(R.drawable.html);
        holder.add(obj5);

        Model obj6 = new Model();
        obj6.setHeader("JavaScript Programming");
        obj6.setDescription("Programming Language");
        obj6.setImageName(R.drawable.javascript);
        holder.add(obj6);

        Model obj7 = new Model();
        obj7.setHeader("Java Programming");
        obj7.setDescription("Programming Language");
        obj7.setImageName(R.drawable.java);
        holder.add(obj7);

        Model obj8 = new Model();
        obj8.setHeader("Php Programming");
        obj8.setDescription("Scripting Language");
        obj8.setImageName(R.drawable.php);
        holder.add(obj8);

        Model obj9 = new Model();
        obj9.setHeader("Kotlin Programming");
        obj9.setDescription("Programming Language");
        obj9.setImageName(R.drawable.kotlin);
        holder.add(obj9);

        Model obj10 = new Model();
        obj10.setHeader("Ruby Programming");
        obj10.setDescription("Programming Language");
        obj10.setImageName(R.drawable.ruby);
        holder.add(obj10);

        Model obj11 = new Model();
        obj11.setHeader("Dart Programming");
        obj11.setDescription("Programming Language");
        obj11.setImageName(R.drawable.dart);
        holder.add(obj11);


        return holder;
    }

    // create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        MenuItem item = menu.findItem(R.id.search_menu);

        // create searchView when click searchBar
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adpter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}