package br.com.regiane.meuapp.meuappcerto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.regiane.meuapp.meuappcerto.estabelecimento.Estabelecimento;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.EstabelecimentoActivity;
import br.com.regiane.meuapp.meuappcerto.estabelecimento.EstabelecimentoListActivity;

public class NovoMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_main);


    }

    public void   abrirUnidade1(View View){
        Intent it= new Intent(this,MainActivity.class);
        startActivity(it);
    }

    public void abrirUnidade2A(View View){
        Intent it = new Intent(this,Tela1Activity.class);
        startActivity(it);
}
    public void abrirUnidade2b(View View){
        Intent it = new Intent(this, EstabelecimentoActivity.class);
        startActivity(it);
    }
    public void abrirUnidade2c(View View){
        Intent it = new Intent(this, EstabelecimentoListActivity.class);
        startActivity(it);
    }
}
