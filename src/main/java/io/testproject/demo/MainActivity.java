package io.testproject.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private TextView fullName;
    private TextView welcome;

    private List<String> names;
    private ArrayAdapter<String> namesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acquire references to UI widgets
        this.firstName = (EditText) findViewById(R.id.firstName);
        this.lastName = (EditText) findViewById(R.id.lastName);
        this.fullName = (TextView) findViewById(R.id.fullName);

        // Update Full Name when First/Last names change
        this.firstName.addTextChangedListener(getFullNameTextWatcher());
        this.lastName.addTextChangedListener(getFullNameTextWatcher());

        // Setup Persons ListView
        this.names = new ArrayList<>();
        namesAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        ListView listView = (ListView) findViewById(R.id.persons);
        listView.setAdapter(namesAdapter);
    }

    public void addPerson(View view) {
        names.add(fullName.getText().toString());
        namesAdapter.notifyDataSetInvalidated();

    }

    private TextWatcher getFullNameTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                fullName.setText(firstName.getText() + " " + lastName.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }
}
