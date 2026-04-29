import java.util.ArrayList;
import java.util.List;

public class SistemaProducao {
    private List<Cliente> clientes;
    private List<Pedido> pedidos;
    private List<ModeloTerno> modelos;

    public SistemaProducao() {
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.modelos = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void cadastrarModelo(ModeloTerno modelo) {
        modelos.add(modelo);
    }

    public void listarPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    public Pedido buscarPedido(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public void atualizarStatusPedido(int id, String novoStatus) {
        Pedido pedido = buscarPedido(id);

        if (pedido != null) {
            pedido.atualizarStatus(novoStatus);
            System.out.println("Status atualizado com sucesso.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void cancelarPedido(int id) {
        Pedido pedido = buscarPedido(id);

        if (pedido != null) {
            pedido.cancelarPedido();
            System.out.println("Pedido cancelado com sucesso.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<ModeloTerno> getModelos() {
        return modelos;
    }
}