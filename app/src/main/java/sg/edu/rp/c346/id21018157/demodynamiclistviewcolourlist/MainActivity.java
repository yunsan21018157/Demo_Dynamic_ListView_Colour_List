package sg.edu.rp.c346.id21018157.demodynamiclistviewcolourlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    EditText etIndexElement;
    Button btnRemove;
    Button btnUpdate;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Green");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newElement = etElement.getText().toString(); //arrayList is string
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, newElement); //adds pos & input
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this,colour,Toast.LENGTH_LONG).show();

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newPos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(newPos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newPos = Integer.parseInt(etIndexElement.getText().toString());
                String newElement = etElement.getText().toString();
                alColours.set(newPos, newElement);
                aaColour.notifyDataSetChanged();
            }
        });



    }
}