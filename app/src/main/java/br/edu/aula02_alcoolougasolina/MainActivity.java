package br.edu.aula02_alcoolougasolina;
// alt enter para fazer import

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // importar as classes sempre que iniciar elas | classes editText e Button
    // arquivos do java | não precisam ter o mesmo nome que os componentes da tela activity
    EditText editGasolina, editEtanol;
    Button btnCalcular;
    Funcoes funcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // indica qual tela está verificando

        funcoes = new Funcoes();
        // dentro da tela/arquivo citado vai procurar a id indicada
        editGasolina    = findViewById(R.id.editGasolina);
        editEtanol      = findViewById(R.id.editEtanol);
        btnCalcular     = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validar campos em branco
                if (editGasolina.getText().toString().isEmpty()) {
                    funcoes.mostrarMensagem(MainActivity.this, "Atenção", "Insira o valor da gasolina");
                    return;
                }

                if (editEtanol.getText().toString().isEmpty()) {
                    funcoes.mostrarMensagem(MainActivity.this, "Atenção", "Insira o valor do etanol.");
                    return;
                }

                // instanciando as vars
                double valorGasolina = 0;
                double valorEtanol = 0;

                try {
                    valorGasolina = Double.parseDouble(editGasolina.getText().toString());
                }
                catch (Exception ex) {
                    //ex.getMessage(); - mensagem de erro do java em que não foi possível converter para double
                    funcoes.mostrarMensagem(MainActivity.this, "Atenção", "Insira o valor da gasolina.");
                    return;
                }

                try {
                    valorEtanol   = Double.parseDouble(editEtanol.getText().toString());
                }
                catch (Exception ex) {
                   // ex.getMessage();
                    funcoes.mostrarMensagem(MainActivity.this, "Atenção", "Insira o valor do etanol");
                    return;
                }

                double resultado     = valorEtanol / valorGasolina;

                if ( resultado <0.7 ) {
                    // melhor etanol
                    // mensagem de aviso | tempo da mensagem da tela
                    Toast.makeText(MainActivity.this, "Abasteça com etanol", Toast.LENGTH_LONG).show();
                    funcoes.mostrarMensagem(MainActivity.this,"Etanol", "Abasteça com etanol");

                    //AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    //alerta.setTitle("Atenção");
                    //alerta.setMessage("Abasteça com etanol");
                    // só muda a posição na tela quando de trata dos buttons neutral, positive e negative
                    // neutral          | não    | sim
                    //alerta.setPositiveButton("OKAY", null);
                }
                else {
                    // melhor gasosa
                    Toast.makeText(MainActivity.this, "Abasteça com gasolina", Toast.LENGTH_LONG).show();
                    funcoes.mostrarMensagem(MainActivity.this, "Gasolina", "Abasteça com gasolina");
                    //alerta.setMessage("Abasteça com Gasolina");
                }
                //alerta.show();
            }
        });
    }

    /* private void mostrarMensagem(String sTitulo, String sMensagem) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setTitle(sTitulo);
        alerta.setMessage(sMensagem);
        alerta.setPositiveButton("OKAY", null);
        alerta.show();
    } */
}