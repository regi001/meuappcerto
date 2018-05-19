package br.com.regiane.meuapp.meuappcerto.avaliacao;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import br.com.regiane.meuapp.meuappcerto.R;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.Estabelecimento;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.EstabelecimentoActivity;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.EstabelecimentoDAO;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.EstabelecimentoListAdapter;

public class AvaliacaoListActivity extends ListActivity {
    AvalciacaoListAdapter adapter;
    Estabelecimento estabelecimento;
    List<Avaliacao> avaliacaos;
    AvaliacaoDAO avaliacaoDAO;

    EstabelecimentoDAO estabelecimentoDAO;


    final int MENU_NOVO = 2;
    final int MENU_CANCELAR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_list);

        // pega o id do estabelecimento do botal salvar
        Intent it = getIntent();
       // String id = it.getStringExtra("_id");
        String id= it.getStringExtra(Estabelecimento.ID);

        //busca o estabeleciemnto e joga pro objeto
        estabelecimentoDAO = new  EstabelecimentoDAO(this);
        Estabelecimento estabelecimento = estabelecimentoDAO.buscar(id);

        //busca todas as avaliações deste estabeleciemnto
        avaliacaoDAO = new AvaliacaoDAO(this);
        avaliacaos = avaliacaoDAO.listar(estabelecimento);



        adapter = new AvalciacaoListAdapter(
                this, R.layout.activity_avaliacao_list_item, avaliacaos);

        setListAdapter(adapter);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2){
            Toast.makeText(this,"Voce licou em Novo!!", Toast.LENGTH_LONG).show();
        }
        if (requestCode==3){
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
                Intent it = new Intent(this, AvaliacaoActivity.class);
                //pega parametro de outra tela
                 it.putExtra("_id",estabelecimento.getId());
                // startActivity(it);
                startActivityForResult(it, 2);

                break;

            case MENU_CANCELAR:
                cancelar();
                break;
        }
        return true;
    }
}

