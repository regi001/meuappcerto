package br.com.regiane.meuapp.meuappcerto;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    Button bt0k, bt0k2;
    EditText edttexto;
    TextView tvTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//liga a variavel que foi declarada acima com o id que foi atribuido ao elemento no activity
        edttexto = findViewById(R.id.main_edTexto);
        //edttexto.setText("regiane");

// quando clica salva o texto no textview
        bt0k = findViewById(R.id.main_btn0k);
        bt0k.setText("Salvar");
        //quando clica limpa o texto no textview

        //bt0k2 = findViewById(R.id.main_btn0k2);
        bt0k.setText("limpar");


        tvTexto = findViewById(R.id.main_textView);
        tvTexto.setText("Regiane");

//a classe R pode buscar da classe string

        bt0k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setaTexto();
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
//salva a informação da tela, atraves da chave definida como valor a
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("valor_a",tvTexto.getText().toString());
    }
    //recupera a informação atraves da chave informada no putString acima

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvTexto.setText(savedInstanceState.getString("valor_a"));
    }
    //modo de ligar a ação do botao com o button da activity_main
    public void ligar(View View) {
        realizarLigacao();
    }

    public void realizarLigacao(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{"Manifest.permission.CALL_PHONE"},1);
        }else{
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:87908654")));
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if ((grantResults.length>0)&&(grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                   realizarLigacao();
            }
            break;
        }
    }

    public void setaTexto() {
        tvTexto.setText(edttexto.getText().toString());
    }


    public void limpaTexto() {
        tvTexto.setText("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("appmain", "passou pelo on resume");
        Toast.makeText(this, "resume", Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("appmain", "passou pelo resume");
        Toast.makeText(this, "start", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("appmain", "passou pelo stop");
        Toast.makeText(this, "stop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("appmain", "passou pelo pause");
        Toast.makeText(this, "stop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("appmain", "passou pelo destroy");
        Toast.makeText(this, "destroy", Toast.LENGTH_LONG).show();
    }


}


