package br.com.regiane.meuapp.meuappcerto.avaliacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import br.com.regiane.meuapp.meuappcerto.estabelecimento.Estabelecimento;
import br.com.regiane.meuapp.meuappcerto.sqlite.BancoDados;

/**
 * Created by regia on 11/05/2018.
 */

public class AvaliacaoDAO {

    SQLiteDatabase db;
    public AvaliacaoDAO(Context context){
        db = BancoDados.getDB(context);
    }

    public void salvar(Avaliacao ava){

        ContentValues values = new ContentValues();
        values.put(Avaliacao.COMENTARIO,ava.getComentarios());
        //o qe vi fazer ele concatenar com a outra tabela é o id
        values.put(Avaliacao.ESTABELECIMENTO,ava.getEstabelecimento().getId());
        values.put(Avaliacao.ESTRELAS,ava.getEstrelas());


        db.insert(Avaliacao.TABELA,null,values);
    }
    public void  alterar(Avaliacao ava){
        String id=String.valueOf(ava.getId());
        String[] where = new String[]{id};

        //atribiu is parametros para o banco de dados

        ContentValues values = new ContentValues();
        values.put(Avaliacao.COMENTARIO,ava.getComentarios());
        values.put(Avaliacao.ESTABELECIMENTO,ava.getEstabelecimento().getId());
        values.put(Avaliacao.ESTRELAS,ava.getEstrelas());
        db.update(Avaliacao.TABELA,values,Avaliacao.ID, where);
    }

    public Avaliacao buscar(String id, Estabelecimento estab){

        String [] colunas = Avaliacao.COLUNAS;
        String [] where = new  String[]{id};

        //as informações vao para o cursor
        Cursor c= db.query(Avaliacao.TABELA,colunas,
                Avaliacao.ID +"= ?",where,null,null,null,null);

        // move os objetos para o inicio e começa ler o objetos
        c.moveToFirst();


        // pega os itens da sua respectiva coluna pelo cursor
        Avaliacao ava = new Avaliacao();
        ava.setId(c.getLong(c.getColumnIndex(Avaliacao.ID)));
        ava.setEstabelecimento(estab);
        ava.setComentarios(c.getString(c.getColumnIndex(Avaliacao.COMENTARIO)));
        ava.setEstrelas(c.getFloat(c.getColumnIndex(Avaliacao.ESTRELAS)));

        return ava;

    }

    //ta pegando o id de estabelecimentos para pegar as avaliaçoes
    public List<Avaliacao> listar(Estabelecimento estab){



        String [] colunas = Avaliacao.COLUNAS;
        String [] where = new String[]{String.valueOf(estab.getId())};

        //as informações vao para o cursor
        Cursor c= db.query(Avaliacao.TABELA,
                colunas,Avaliacao.ESTABELECIMENTO + "=?",where,null,null,null);


        // lista de avaliacao
        List<Avaliacao> avaliacaos = new ArrayList<Avaliacao>();

        // move os objetos para o inicio e começa ler o objetos
        if(c.moveToFirst()){
            do {
                // pega os itens da sua respectiva coluna pelo cursor
                Avaliacao ava = new Avaliacao();
                ava.setId(c.getLong(c.getColumnIndex(Avaliacao.ID)));
                ava.setEstabelecimento(estab);
                ava.setComentarios(c.getString(c.getColumnIndex(Avaliacao.COMENTARIO)));
                ava.setEstrelas(c.getFloat(c.getColumnIndex(Avaliacao.ESTRELAS)));


                avaliacaos.add(ava);



            }while (c.moveToNext());
        }
        return avaliacaos;

    }

    public void excluir(String id){
        String[] where = new String[]{id};
        db.delete(Avaliacao.TABELA,Avaliacao.ID +"=?", where);

    }
}
