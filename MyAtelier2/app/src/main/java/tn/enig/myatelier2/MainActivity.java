package tn.enig.myatelier2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    ListView l;
    String[] tutorials = { "Liste des contacts", "Ajouter un contact", "Vider la base", };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);
        //listview
        l = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, tutorials);
        l.setAdapter(arr);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) { // 1 correspond à "Ajouter un contact" dans le tableau tutorials
                    Intent intent1 = new Intent(MainActivity.this, AddContact.class);
                    startActivity(intent1);
                }
                if (position == 0) { // 0 correspond à "List des contact" dans le tableau tutorials
                    Intent intent0 = new Intent(MainActivity.this, ListContact.class);
                    startActivity(intent0);
                }
            }
        });

    }

}