package br.com.regiane.meuapp.meuappcerto.avaliacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import br.com.regiane.meuapp.meuappcerto.R;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.Estabelecimento;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.EstabelecimentoDAO;

public class AvaliacaoActivity extends Activity {

    RatingBar rbEstrelas;
    EditText edtComentario;
    AvaliacaoDAO avaliacaoDAO;
    EstabelecimentoDAO estabelecimentoDAO;

    Estabelecimento estabelecimento;
    final int MENU_SALVAR = 1;
    final int MENU_CANCELAR = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        Intent it = getIntent();
        // String id = it.getStringExtra("_id");
        String id= String.valueOf(it.getLongExtra(Estabelecimento.ID,0));

        rbEstrelas = findViewById(R.id.avaliacao_rbEstrelas);
        edtComentario = findViewById(R.id.avaliacao_edtComentario);

        avaliacaoDAO = new AvaliacaoDAO(this);
        estabelecimentoDAO = new EstabelecimentoDAO(this);

        estabelecimento = new Estabelecimento();
        estabelecimento = estabelecimentoDAO.buscar(id);



    }

    public void salvar(){
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setEstrelas(rbEstrelas.getRating());
        avaliacao.setComentarios(edtComentario.getText().toString());
        avaliacao.setEstabelecimento(estabelecimento);

        avaliacaoDAO.salvar(avaliacao);
        finish();
    }
    public  void novo(){

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

        menu.add(0,MENU_SALVAR,0,"novo");
        menu.add(0,MENU_CANCELAR,0,"Cancelar");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_SALVAR:

                salvar();
                break;

            case MENU_CANCELAR:
                cancelar();
                break;
        }
        return true;
    }


}
