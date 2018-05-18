package br.com.regiane.meuapp.meuappcerto.estabelecimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.regiane.meuapp.meuappcerto.sqlite.BancoDados;

/**
 * Created by regia on 27/04/2018.
 */

public class EstabelecimentoDAO {
    SQLiteDatabase db;
    public EstabelecimentoDAO(Context context){
        db = BancoDados.getDB(context);
    }

    public void salvar(Estabelecimento est){

        ContentValues values = new ContentValues();
        values.put(Estabelecimento.NOME,est.getNome());
        values.put(Estabelecimento.ENDERECO,est.getEndereco());
        values.put(Estabelecimento.TELEFONE,est.getTelefone());
        values.put(Estabelecimento.SLOGAN,est.getSlogan());
        values.put(Estabelecimento.LATITUDE,est.getLatitude());
        values.put(Estabelecimento.LONGITUDE,est.getLongitude());

        db.insert(Estabelecimento.TABELA,null,values);
    }
    public void  alterar(Estabelecimento est){
        String id=String.valueOf(est.getId());
        String[] where = new String[]{id};

        //atribiu is parametros para o banco de dados

        ContentValues values = new ContentValues();
        values.put(Estabelecimento.NOME,est.getNome());
        values.put(Estabelecimento.ENDERECO,est.getEndereco());
        values.put(Estabelecimento.ENDERECO,est.getTelefone());
        values.put(Estabelecimento.SLOGAN,est.getSlogan());
        values.put(Estabelecimento.LATITUDE,est.getLatitude());
        values.put(Estabelecimento.LONGITUDE,est.getLongitude());
        db.update(Estabelecimento.TABELA,values,"_id = ?", where);
    }
    public Estabelecimento buscar(String id){

        //um array para recuperas as informaçoes da tabela
       // String [] colunas = new String[]{"_id","nome","endereco","telefone","slogan", "latitude","longitude"};

        String [] colunas = Estabelecimento.COLUNAS;
        String [] where = new  String[]{id};

        //as informações vao para o cursor
        Cursor c= db.query(Estabelecimento.TABELA,colunas,
        "_id = ?",where,null,null,null,null);

        // move os objetos para o inicio e começa ler o objetos
        c.moveToFirst();


        // pega os itens da sua respectiva coluna pelo cursor
        Estabelecimento est = new Estabelecimento();
        est.setId(c.getLong(c.getColumnIndex(Estabelecimento.ID)));
        est.setNome(c.getString(c.getColumnIndex(Estabelecimento.NOME)));
        est.setEndereco(c.getString(c.getColumnIndex(Estabelecimento.ENDERECO)));
        est.setTelefone(c.getString(c.getColumnIndex(Estabelecimento.TELEFONE)));
        est.setSlogan(c.getString(c.getColumnIndex(Estabelecimento.SLOGAN)));
        est.setLatitude(c.getString(c.getColumnIndex(Estabelecimento.LATITUDE)));
        est.setLongitude(c.getString(c.getColumnIndex(Estabelecimento.LONGITUDE)));

        return est;

    }
    public List<Estabelecimento> listar(){

        //um array para recuperas as informaçoes da tabela
        // String [] colunas = new String[]{"_id","nome","endereco","telefone","slogan", "latitude","longitude"};

        String [] colunas = Estabelecimento.COLUNAS;
       // String [] where = new  String[]{id};

        //as informações vao para o cursor
        Cursor c= db.query(Estabelecimento.TABELA,
                colunas,null,null,null,null,null);


        // lista de estebelecimentos
        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        // move os objetos para o inicio e começa ler o objetos
        if(c.moveToFirst()){
            do {
                // pega os itens da sua respectiva coluna pelo cursor
                Estabelecimento est = new Estabelecimento();
                est.setId(c.getLong(c.getColumnIndex(Estabelecimento.ID)));
                est.setNome(c.getString(c.getColumnIndex(Estabelecimento.NOME)));
                est.setEndereco(c.getString(c.getColumnIndex(Estabelecimento.ENDERECO)));
                est.setTelefone(c.getString(c.getColumnIndex(Estabelecimento.TELEFONE)));
                est.setSlogan(c.getString(c.getColumnIndex(Estabelecimento.SLOGAN)));
                est.setLatitude(c.getString(c.getColumnIndex(Estabelecimento.LATITUDE)));
                est.setLongitude(c.getString(c.getColumnIndex(Estabelecimento.LONGITUDE)));

                estabelecimentos.add(est);

                Log.i("lista",est.getId() + est.getNome());

            }while (c.moveToNext());
        }
        return estabelecimentos;

    }

    public void excluir(String id){
        String[] where = new String[]{id};
         db.delete(Estabelecimento.TABELA,"_id = ?", where);

    }
}
