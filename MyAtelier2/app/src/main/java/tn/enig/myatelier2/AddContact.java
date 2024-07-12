package tn.enig.myatelier2;





import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddContact extends AppCompatActivity {
    // creating variables for our edittext, button and dbhandler
    private EditText contactNameEdt, contactTelEdt, contactEmailEdt;
    private DBHandler dbHandler;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // initializing all our variables.
        contactNameEdt = findViewById(R.id.name);
        contactTelEdt = findViewById(R.id.tel);
        contactEmailEdt = findViewById(R.id.email);
        Button addCourseBtn = findViewById(R.id.button);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(AddContact.this);
        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String contactName = contactNameEdt.getText().toString();
                String contactTel = contactTelEdt.getText().toString();
                String contactEmail = contactEmailEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (contactName.isEmpty() && contactTel.isEmpty() && contactEmail.isEmpty() ) {
                    Toast.makeText(AddContact.this, "Please enter all the data.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewContact(contactName, contactTel, contactEmail);

                // after adding the data we are displaying a toast message.
                Toast.makeText(AddContact.this, "Contact has been added.", Toast.LENGTH_SHORT).show();
                contactNameEdt.setText("");
                contactTelEdt.setText("");
                contactEmailEdt.setText("");
            }
        });
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}