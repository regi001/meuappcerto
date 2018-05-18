package br.com.regiane.meuapp.meuappcerto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Tela1Activity extends Activity {
    //constante
    final int MENU_NOVO = 1;
    final int MENU_CANCELAR = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
    }

    public void abrirNovo(View View){
        Intent it= new Intent(this,Tela2Activity.class);
        //parametro        identificação  mensagem
        it.putExtra("chave1","meu primeiro parametro");
        it.putExtra("chave2","meu segundo parametro");

        //inicia a tela

        //startActivity(it);

        // starta a activity

        startActivityForResult(it,1);

    }

    public void novo(){
        Intent it= new Intent(this,Tela2Activity.class);
        //parametro        identificação  mensagem
        it.putExtra("chave1","meu primeiro parametro");
        it.putExtra("chave2","meu segundo parametro");
        startActivityForResult(it,1);
    }
//trata os intens que vem da outra tela
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            Toast.makeText(this, "voce clicou em novo", Toast.LENGTH_LONG).show();
        }
        if (requestCode == 2) {
            Toast.makeText(this, "voce clicou em cancelar", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,MENU_NOVO,0,"Novo");
        menu.add(0,MENU_CANCELAR,0,"cancelar");
        return true;
    }
    //para pegar o intem do menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case MENU_NOVO:
                novo();
                break;
            case MENU_CANCELAR:
                cancelar();
                break;

        }
        return true;
    }

    public void abrirCancelar (View View){

        Intent it = new Intent(this,Tela2Activity.class);

        startActivityForResult(it,2);


    }
    public void cancelar(){
        Intent it = new Intent(this,Tela2Activity.class);

        startActivityForResult(it,2);

    }


}
