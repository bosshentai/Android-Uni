package com.example.penuria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NovoContacto extends AppCompatActivity {


    DBHelper db;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contacto);

        db = new DBHelper(this);
    }

    public void cancelHandler(View view) {
    }

    public void insertContact(View view) {

        String nome = "Marvin";
        String morada = "lomba";
        String telemovel = "teste";
        String sexo = "femin";
        String email = "bapt";

        if (nome.isEmpty() || morada.isEmpty() || telemovel.isEmpty() || sexo.isEmpty() || email.isEmpty())
            Toast.makeText(NovoContacto.this, "Preencha todos os campos antes de gravar o contacto", Toast.LENGTH_SHORT).show();
        else {

            if(db !=null){
                long res = db.Insert_Contacto(nome,morada,telemovel,sexo,email);

                if(res > 0){
                    Toast.makeText(NovoContacto.this, "Utilizador criado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(NovoContacto.this, "Erro ao criar utilizador", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(NovoContacto.this, "DB is null ", Toast.LENGTH_SHORT).show();
            }
//                    Log.d("123",nome);
//                    Log.d("123",morada);
//                    Log.d("123",telemovel);
//                    Log.d("123",sexo);
//                    Log.d("123",email);

            // Gravar os dados na lista de contactos

//
//            long res = db.Insert_Contacto(nome, morada, telemovel, sexo, email);
////                    Log.d("123",""+res);
//            if (res > 0) { // Validar este processo
//                Toast.makeText(NovoContacto.this, "Utilizador criado com sucesso", Toast.LENGTH_SHORT).show();
////                setResult(1, i);
//                finish();
//            } else {
//                Toast.makeText(NovoContacto.this, "Erro ao criar utilizador", Toast.LENGTH_SHORT).show();
//            }
        }
    }
}