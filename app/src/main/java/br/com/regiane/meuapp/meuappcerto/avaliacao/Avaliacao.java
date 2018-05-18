package br.com.regiane.meuapp.meuappcerto.avaliacao;

import br.com.regiane.meuapp.meuappcerto.estabelecimento.Estabelecimento;

/**
 * Created by regia on 11/05/2018.
 */

public class Avaliacao {
    private Long id;
    private Estabelecimento estabelecimento;
    private String comentarios;
    private float estrelas;

    final static String ID = "_id";
    final static  String ESTABELECIMENTO = "estabelecimento";
    final static String COMENTARIO = "comentarios";
    final static String ESTRELAS = "estrelas";

    final static String TABELA = "tbl_avaliacao";
    final static String [] COLUNAS = new String[]{ID,ESTABELECIMENTO,COMENTARIO,ESTRELAS};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public float getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(float estrelas) {
        this.estrelas = estrelas;
    }
}
