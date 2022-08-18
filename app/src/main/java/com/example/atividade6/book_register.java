package com.example.atividade6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class book_register extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextAuthor;
    private RadioGroup radioGroupStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_register);
        radioGroupStatus = findViewById(R.id.radioGroup);
        editTextTitle = findViewById(R.id.editTextRegisterTitle);
        editTextAuthor = findViewById(R.id.editTextAuthor);
    }

    public void finish(View view){
        String status = "";
        Intent cadastro = new Intent();
        cadastro.putExtra("title", editTextTitle.getText().toString());
        cadastro.putExtra("author", editTextAuthor.getText().toString());

        switch (radioGroupStatus.getCheckedRadioButtonId()){
            case R.id.radioButtonNotRead:
                status = "Not Read";
                break;
            case R.id.radioButtonReading:
                status = "Reading";
                break;
            case R.id.radioButtonReaded:
                status = "Readed";
                break;
            default:
                break;
        }

        cadastro.putExtra("status", status);

        setResult(RESULT_OK, cadastro);
        finish();
    }

    public void cancel(View view){
        finish();
    }
}