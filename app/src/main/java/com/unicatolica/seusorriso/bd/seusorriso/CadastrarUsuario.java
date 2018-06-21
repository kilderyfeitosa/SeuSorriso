package com.unicatolica.seusorriso.bd.seusorriso;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.unicatolica.seusorriso.R;

public class CadastrarUsuario extends AppCompatActivity {
    SeuSorrisoDB seuSorrisoDB;
    EditText txtMatricula, txtNome, txtSenha;
    RadioGroup radioGroup;
    String op;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupOP);
        txtMatricula = (EditText) findViewById(R.id.edtMatricula);
        txtNome = (EditText) findViewById(R.id.edtNome);
        txtSenha = (EditText) findViewById(R.id.edtSenha);

    }

    public void salvar(View view){
        String matriculaString = txtMatricula.getText().toString();
        String nomeString = txtNome.getText().toString();
        String senhaString = txtSenha.getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.opAluno:
                        op = "aluno";
                        break;

                    case R.id.opProfessor:
                        op = "professor";
                        break;
                }
            }
        });

        seuSorrisoDB = new SeuSorrisoDB(this);

        String resultado = seuSorrisoDB.inserirDados(matriculaString, nomeString, senhaString, op);

        Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();

        }
    }

