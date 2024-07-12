package tn.enig.myatelier2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactTVAdapter extends RecyclerView.Adapter<ContactTVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<ContactModal> contactModalArrayList;
    private Context context;

    // constructor
    public ContactTVAdapter(ArrayList<ContactModal> courseModalArrayList, Context context) {
        this.contactModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listcontact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        ContactModal modal = contactModalArrayList.get(position);
        holder.contactNameTV.setText(modal.getContactName());
        holder.contactTelTV.setText(modal.getContactTel());
        holder.contactEmailTV.setText(modal.getContactEmail());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return contactModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView contactNameTV, contactTelTV, contactEmailTV;

        public ViewHolder( View itemView) {
            super(itemView);
            // initializing our text views
            contactNameTV = itemView.findViewById(R.id.idTVContactName);
            contactTelTV = itemView.findViewById(R.id.idTVContactTel);
            contactEmailTV = itemView.findViewById(R.id.idTVContactEmail);
        }
    }
}

