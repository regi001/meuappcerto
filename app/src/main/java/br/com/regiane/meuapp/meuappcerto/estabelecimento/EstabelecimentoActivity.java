package br.com.regiane.meuapp.meuappcerto.estabelecimento;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import br.com.regiane.meuapp.meuappcerto.R;
import br.com.regiane.meuapp.meuappcerto.avaliacao.AvaliacaoListActivity;
import br.com.regiane.meuapp.meuappcerto.sqlite.BancoDados;

public class EstabelecimentoActivity extends Activity {
    EditText edtid, edtnome, edtendereco, edtfone, edtslogan,edtLatitude,edtLongitude;
    //SQLiteDatabase db;

    // troca o db e passa a buscar tudo do dao
    EstabelecimentoDAO dao;

    final int MENU_SALVAR = 1;
    final int MENU_ALTERAR = 2;
    final int MENU_BUSCAR = 3;
    final int MENU_EXCLUIR = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento);

// isso cria o banco de dados
       // db = BancoDados.getDB(this);

        dao = new EstabelecimentoDAO(this);

        edtid = findViewById(R.id.estabelecimento_edtId);
        edtnome = findViewById(R.id.estabelecimento_edtNome);
        edtendereco = findViewById(R.id.estabelecimento_edtEndereco);
        edtfone = findViewById(R.id.estabelecimento_edtTelefone);
        edtslogan = findViewById(R.id.estabelecimento_edtSlogan);
        edtLatitude = findViewById(R.id.estabelecimento_edtLatitude);
        edtLongitude = findViewById(R.id.estabelecimento_edtLongitude);

        Intent it = getIntent();
        Long id = it.getLongExtra(Estabelecimento.ID,0);

        if(id != 0){
            edtid.setText(String.valueOf(id));
            buscarEstabelecimeto();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_SALVAR, 0, "salvar");
        menu.add(0, MENU_ALTERAR, 0, "alterar");
        menu.add(0, MENU_BUSCAR, 0, "buscar");
        menu.add(0, MENU_EXCLUIR, 0, "excluir");
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case MENU_SALVAR:
                salvarEstabeleciemento();
                break;
            case MENU_ALTERAR:
                alterarEstabelecimento();
                break;
            case MENU_BUSCAR:
                buscarEstabelecimeto();
                break;
            case MENU_EXCLUIR:
                excluirEstabelecimento();
                break;

        }
        return true;
    }



    public void salvarEstabeleciemento(){
        Estabelecimento est = new Estabelecimento();
        est.setNome(edtnome.getText().toString());
        est.setEndereco(edtendereco.getText().toString());
        est.setTelefone(edtfone.getText().toString());
        est.setSlogan(edtslogan.getText().toString());
        est.setLatitude(edtLatitude.getText().toString());
        est.setLongitude(edtLongitude.getText().toString());

        //atribiu is parametros para o banco de dados

/*
        ContentValues values = new ContentValues();
        values.put("nome",est.getNome());
        values.put("endereco",est.getEndereco());
        values.put("telefone",est.getTelefone());
        values.put("slogan",est.getSlogan());
        values.put("latitude",est.getLatitude());
        values.put("longitude",est.getLongitude());
*/
        //comando para inserir os campos na tabela

       // db.insert("tbl_estabelecimento",null,values);

        dao.salvar(est);

        //para encerrrar a tela depois que salva os campos
        finish();

    }
    public void alterarEstabelecimento(){
        Estabelecimento est = new Estabelecimento();
        est.setId(Long.valueOf(edtid.getText().toString()));
        est.setNome(edtnome.getText().toString());
        est.setEndereco(edtendereco.getText().toString());
        est.setTelefone(edtfone.getText().toString());
        est.setSlogan(edtslogan.getText().toString());
        est.setLatitude(edtLatitude.getText().toString());
        est.setLongitude(edtLongitude.getText().toString());
/*
        String[] where = new String[]{edtid.getText().toString()};

        //atribiu is parametros para o banco de dados

        ContentValues values = new ContentValues();
        values.put("nome",est.getNome());
        values.put("endereco",est.getEndereco());
        values.put("telefone",est.getTelefone());
        values.put("slogan",est.getSlogan());
        values.put("latitude",est.getLatitude());
        values.put("longitude",est.getLongitude());

        //comando para alterar os dados na tabela

       // db.update("tbl_estabelecimento",values,"_id = ?", where);


*/
        dao.alterar(est);
        //para encerrrar a tela depois que salva os campos
        finish();

    }
    public void buscarEstabelecimeto(){
        /*
        //um array para recuperas as informaçoes da tabela
        String [] colunas = new String[]{"_id","nome","endereco","telefone","slogan", "latitude","longitude"};
        String [] where = new  String[]{edtid.getText().toString()};

        //as informações vao para o cursor
        Cursor c;//= db.query("tbl_estabelecimento",colunas,
                //"_id = ?",where,null,null,null,null);

        // move os objetos para o inicio e começa ler o objetos
        c.moveToFirst();

        // pega os itens da sua respectiva coluna pelo cursor
        Estabelecimento est = new Estabelecimento();
        est.setId(c.getLong(c.getColumnIndex("_id")));
        est.setNome(c.getString(c.getColumnIndex("nome")));
        est.setEndereco(c.getString(c.getColumnIndex("endereco")));
        est.setTelefone(c.getString(c.getColumnIndex("telefone")));
        est.setSlogan(c.getString(c.getColumnIndex("slogan")));
        est.setLatitude(c.getString(c.getColumnIndex("latitude")));
        est.setLongitude(c.getString(c.getColumnIndex("longitude")));
*/
        //jogar os itens instanciandos no est e joga na tela

        Estabelecimento est =dao.buscar(edtid.getText().toString());

        edtnome.setText(est.getNome());
        edtendereco.setText(est.getEndereco());
        edtfone.setText(est.getTelefone());
        edtslogan.setText(est.getSlogan());
        edtLatitude.setText(est.getLatitude());
        edtLongitude.setText(est.getLongitude());
    }
    public void excluirEstabelecimento(){
        /*
        String[] where = new String[]{edtid.getText().toString()};
       // db.delete("tbl_estabelecimento","_id = ?", where);

       */

        dao.excluir(edtid.getText().toString());
        finish();

    }

    public void abrirListaAvaliação (View view){
        Intent it = new Intent(this, AvaliacaoListActivity.class);
        // pegar o id do estabelecimento e vai passa pra lista de avaliações
        it.putExtra(Estabelecimento.ID,edtid.getText().toString());
        startActivityForResult(it,1);

    }
}
