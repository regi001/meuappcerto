package br.com.regiane.meuapp.meuappcerto.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoDados {

	// Nome do banco
	private static final String NOME_BANCO = "meuapp";
	// Controle de versao// sempre que mudar alguma coisa no banco tem que mudar a versãp para dar certo
	private static final int VERSAO_BANCO = 5;
	// Script para fazer drop na tabela
	private static final String[] SCRIPT_DATABASE_DELETE = new String[] {
			"DROP TABLE IF EXISTS tbl_estabelecimento;",
			"DROP TABLE IF EXISTS tbl_avaliacao;",
																		 };

	
	// Cria a tabela com o "_id" sequencial
	private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
			"create table tbl_estabelecimento(_id integer primary key, nome text,endereco text, telefone text, slogan text, latitude text, longitude text );",
			"create table tbl_avaliacao (_id integer primary key, estabelecimento tex, comentarios text,estrelas real);"
	};

	private static SQLiteDatabase db;

	public static SQLiteDatabase getDB(Context ctx) {
		if (db == null) {			
			SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
			db = dbHelper.getWritableDatabase();
		}
		return db;
		
	}
	
	

}
