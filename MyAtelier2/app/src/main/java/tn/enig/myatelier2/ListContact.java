package tn.enig.myatelier2;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListContact extends AppCompatActivity {
    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<ContactModal> contactModalArrayList;
    private DBHandler dbHandler;
    private ContactTVAdapter contactTVAdapter;
    private RecyclerView contactRV;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontact);

        // initializing our all variables.
        contactModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ListContact.this);

        // getting our course array
        // list from db handler class.
        contactModalArrayList = dbHandler.readCourses();

        // on below line passing our array list to our adapter class.
        contactTVAdapter = new ContactTVAdapter(contactModalArrayList, ListContact.this);
        contactRV = findViewById(R.id.idRVContact);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListContact.this, RecyclerView.VERTICAL, false);
        contactRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        contactRV.setAdapter(contactTVAdapter);
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
