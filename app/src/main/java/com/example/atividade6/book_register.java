package com.example.atividade6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();


        cadastro.putExtra("title", title);
        cadastro.putExtra("author", author);

        switch (radioGroupStatus.getCheckedRadioButtonId()){
            case R.id.radioButtonNotRead:
                status = "Não Lido";
                break;
            case R.id.radioButtonReading:
                status = "Lendo";
                break;
            case R.id.radioButtonReaded:
                status = "Lido";
                break;
            default:
                break;
        }

        cadastro.putExtra("status", status);
        cadastro.putExtra("activity", "create");

        if(title.length() > 0 && title.length() > 0 && author.length() > 0 && author.length() > 0 && status.length() > 0 && status.length() > 0){
            setResult(RESULT_OK, cadastro);
            finish();
        }

        else{
            Toast.makeText(this, "É necessário informar todos os dados para finalizar cadastro!", Toast.LENGTH_SHORT).show();
        }

    }

    public void cancel(View view){
        finish();
    }
}