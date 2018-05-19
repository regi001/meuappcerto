package br.com.regiane.meuapp.meuappcerto.avaliacao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import br.com.regiane.meuapp.meuappcerto.R;

/**
 * Created by regia on 18/05/2018.
 */

public class AvalciacaoListAdapter extends ArrayAdapter<Avaliacao> {
    Context context;
    int layout;
    List<Avaliacao> avaliacaos;



    public AvalciacaoListAdapter(@NonNull Context context, int resource, @NonNull List<Avaliacao> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.avaliacaos=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater
                = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = inflater.inflate(layout,null);

        RatingBar rbEstrelas = item.findViewById(R.id.avaliacao_list_item_rbEstrelas);
        TextView tvComentario = item.findViewById(R.id.avaliacao_list_item_tvAvaliacao);

        Avaliacao avaliacao = avaliacaos.get(position);
        rbEstrelas.setRating(avaliacao.getEstrelas());
        tvComentario.setText(avaliacao.getComentarios());


        return item;
    }
}
