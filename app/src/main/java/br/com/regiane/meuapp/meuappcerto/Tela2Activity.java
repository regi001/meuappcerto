package br.com.regiane.meuapp.meuappcerto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2Activity extends Activity {

    TextView tvParm1, tvParm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        // faz a junção das vaariavel com o id da tela

        tvParm1 = findViewById(R.id.tela2_tvParm1);
        tvParm2 = findViewById(R.id.tela2_tvParm2);

        //pega uma itenção da outra tela
        Intent it = getIntent();

        // busca a string da outra tela
        String parm1 =it.getStringExtra("chave1");
        String parm2 = it.getStringExtra("chave2");

        tvParm1.setText(parm1);
        tvParm2.setText(parm2);
    }
}
