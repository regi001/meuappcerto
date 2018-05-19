package br.com.regiane.meuapp.meuappcerto.estabelecimento;

/**
 * Created by regia on 13/04/2018.
 */

public class Estabelecimento {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String slogan;
    private String latitude;
    private String longitude;

  public   final  static String ID ="_id";
    final  static String NOME ="nome";
    final  static String ENDERECO ="endereco";
    final  static String TELEFONE ="telefone";
    final  static String SLOGAN ="slogan";
    final  static String LATITUDE ="latitude";
    final  static String LONGITUDE ="longitude";

    final  static String TABELA ="tbl_estabelecimento";

    final static  String [] COLUNAS = new String[]{ID,NOME,ENDERECO,TELEFONE,SLOGAN,LATITUDE,LONGITUDE};


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


}
