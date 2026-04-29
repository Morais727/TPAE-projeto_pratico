import java.time.LocalDate;

public class Pedido {
    private int id;
    private Cliente cliente;
    private ModeloTerno modelo;
    private int quantidade;
    private String tamanho;
    private String cor;
    private String tecido;
    private String status;
    private LocalDate dataPedido;
    private LocalDate dataPrevistaEntrega;
    private String observacoes;

    public Pedido(int id, Cliente cliente, ModeloTerno modelo, int quantidade,
                  String tamanho, String cor, String tecido, String status,
                  LocalDate dataPedido, LocalDate dataPrevistaEntrega, String observacoes) {
        this.id = id;
        this.cliente = cliente;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.cor = cor;
        this.tecido = tecido;
        this.status = status;
        this.dataPedido = dataPedido;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.observacoes = observacoes;
    }

    public Pedido() {
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public ModeloTerno getModelo() {
        return modelo;
    }

    public void setModelo(ModeloTerno modelo) {
        this.modelo = modelo;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


    public String getTecido() {
        return tecido;
    }

    public void setTecido(String tecido) {
        this.tecido = tecido;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }


    public LocalDate getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }


    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // Métodos do diagrama

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public void cancelarPedido() {
        this.status = "Cancelado";
    }

    public void editarPedido(int quantidade, String tamanho, String cor,
                              String tecido, LocalDate dataPrevistaEntrega, String observacoes) {
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.cor = cor;
        this.tecido = tecido;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", modelo=" + modelo.getNome() +
                ", quantidade=" + quantidade +
                ", tamanho='" + tamanho + '\'' +
                ", cor='" + cor + '\'' +
                ", tecido='" + tecido + '\'' +
                ", status='" + status + '\'' +
                ", dataPedido=" + dataPedido +
                ", dataPrevistaEntrega=" + dataPrevistaEntrega +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}