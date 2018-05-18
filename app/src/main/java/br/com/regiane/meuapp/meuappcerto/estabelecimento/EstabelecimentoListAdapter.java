package br.com.regiane.meuapp.meuappcerto.estabelecimento;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.regiane.meuapp.meuappcerto.R;

/**
 * Created by regia on 04/05/2018.
 */

public class EstabelecimentoListAdapter  extends ArrayAdapter<Estabelecimento>{

    Context context;
    int layout;
    List<Estabelecimento> estabelecimentos;

    public EstabelecimentoListAdapter(@NonNull Context context, int resource, @NonNull List<Estabelecimento> objects) {
        super(context, resource, objects);
        this.context =context;
        this.layout = resource;
        this.estabelecimentos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater
                = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item = inflater.inflate(layout,null);
       TextView tvnome = item.findViewById(R.id.estabelecimento_listitem_tvNome);
        TextView tvSlogan = item.findViewById(R.id.estabelecimento_listitem_tvSlogan);
        TextView tvTelefone = item.findViewById(R.id.estabelecimento_listitem_tvTelefone);
        Estabelecimento est = estabelecimentos.get(position);

        tvnome.setText(est.getNome());
        tvSlogan.setText(est.getSlogan());
        tvTelefone.setText(est.getTelefone());
        return item;
    }
}


