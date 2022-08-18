package com.example.atividade6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class update_book extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextAuthor;
    private RadioGroup radioGroupStatus;
    private AppDatabase database;
    private Book updatedBook;
    private Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);
        Bundle extras = getIntent().getExtras();
        database = AppDatabase.getInstance(this.getApplicationContext());

        radioGroupStatus = findViewById(R.id.radioGroup2);
        editTextTitle = findViewById(R.id.editTextRegisterTitleUpdate);
        editTextAuthor = findViewById(R.id.editTextAuthorUpdate);

        id = extras.getLong("livroId");

        updatedBook = database.bookDao().findById(id);

        editTextTitle.setText(updatedBook.getTitle());
        editTextAuthor.setText(updatedBook.getAuthor());
    }

    public void finish(View view){
        String status = "";
        Intent atualizacao = new Intent();

        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();

        switch (radioGroupStatus.getCheckedRadioButtonId()){
            case R.id.radioButtonNotReadUpdate:
                status = "Não Lido";
                break;
            case R.id.radioButtonReadingUpdate:
                status = "Lendo";
                break;
            case R.id.radioButtonReadedUpdate:
                status = "Lido";
                break;
            default:
                break;
        }

        if(title.length() > 0 && title.length() > 0 && author.length() > 0 && author.length() > 0 && status.length() > 0 && status.length() > 0){

            updatedBook.setTitle(title);
            updatedBook.setAuthor(author);
            updatedBook.setStatus(status);

            database.bookDao().saveBook(updatedBook);

            atualizacao.putExtra("activity", "update");

            setResult(RESULT_OK, atualizacao);
            finish();
        }

        else{
            Toast.makeText(this, "Não é possível atualizar campos vazios!", Toast.LENGTH_SHORT).show();
        }

    }

    public void cancel(View view){
        finish();
    }
}