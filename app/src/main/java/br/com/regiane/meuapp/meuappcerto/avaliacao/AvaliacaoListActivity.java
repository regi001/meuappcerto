package br.com.regiane.meuapp.meuappcerto.avaliacao;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.regiane.meuapp.meuappcerto.R;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.EstabelecimentoActivity;

public class AvaliacaoListActivity extends ListActivity {
    final int MENU_NOVO = 1;
    final int MENU_CANCELAR = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_list);
    }
    public  void novo(){
        Intent it = new Intent(this, EstabelecimentoActivity.class);
        // startActivity(it);
        startActivityForResult(it, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            Toast.makeText(this,"Voce licou em Novo!!", Toast.LENGTH_LONG).show();
        }
        if (requestCode==2){
            Toast.makeText(this,"Voce Clicou em Cancelar!!", Toast.LENGTH_LONG).show();
        }
    }
    public void cancelar(){
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,MENU_NOVO,0,"novo");
        menu.add(0,MENU_CANCELAR,0,"Cancelar");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_NOVO:
                novo();
                break;

            case MENU_CANCELAR:
                cancelar();
                break;
        }
        return true;
    }
}
