package model;

import java.util.List;

public class Veiculo {

    private Integer id;
    private String  modelo;
    private String  marca;
    private String  placa;
    private String  cor;
    private String  categoria;
    private String  localizacao;
    private Integer anoFabricacao;
    private Integer kilometragem;
    private Double  preco;
    private String  tipo;

    public  Veiculo(){

    }

    public Veiculo(Integer id, String modelo, String marca, String placa, String cor, String categoria, String localizacao, Integer anoFabricacao, Integer kilometragem, Double preco, String tipo) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
        this.categoria = categoria;
        this.localizacao = localizacao;
        this.anoFabricacao = anoFabricacao;
        this.kilometragem = kilometragem;
        this.preco = preco;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // mostra todos os carros
    public void consultar(List<Veiculo> lista){
        for(Veiculo showList: lista){
            System.out.println(showList);
        }
    }

    //pegar id específico

    public Integer findById(List<Veiculo> lista, int buscarId){

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == buscarId){
                return i;
            }
        }
        return null;
    }

    // Deletar determinado carro por id
    public void deleteById(List<Veiculo> lista, int buscarId){

        Veiculo searchId = lista.stream().filter(x -> x.getId() == buscarId).findFirst().orElse(null);

        if(searchId == null){
            System.out.println("Id Inexistente!");
        }
        else{
            lista.remove(searchId);
            System.out.println("Registro Excluído com Sucesso!");
        }
    }

    @Override
    public String toString() {
        return "Veiculo { " + "\n" +
                "  ID = " + id + "\n" +
                "  Modelo = " + modelo + '\n' +
                "  Marca = " + marca + '\n' +
                "  Placa = " + placa + '\n' +
                "  Cor = " + cor + '\n' +
                "  Categoria = " + categoria + '\n' +
                "  Estado = " + localizacao + '\n' +
                "  Ano de Fabricacao = " + anoFabricacao + '\n' +
                "  Kilometragem = " + kilometragem + '\n' +
  String.format("  Preço: R$ %.2f%n", preco) +
                "  Tipo = " + tipo + "\n" +
                " }";
    }
}
