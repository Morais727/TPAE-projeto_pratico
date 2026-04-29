import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SistemaProducao sistema = new SistemaProducao();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE PRODUÇÃO DE TERNOS =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar modelo de terno");
            System.out.println("3 - Cadastrar pedido");
            System.out.println("4 - Listar pedidos");
            System.out.println("5 - Atualizar status do pedido");
            System.out.println("6 - Cancelar pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(sistema, entrada);
                    break;

                case 2:
                    cadastrarModelo(sistema, entrada);
                    break;

                case 3:
                    cadastrarPedido(sistema, entrada);
                    break;

                case 4:
                    sistema.listarPedidos();
                    break;

                case 5:
                    System.out.print("Digite o ID do pedido: ");
                    int idStatus = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Digite o novo status: ");
                    String novoStatus = entrada.nextLine();

                    sistema.atualizarStatusPedido(idStatus, novoStatus);
                    break;

                case 6:
                    System.out.print("Digite o ID do pedido: ");
                    int idCancelar = entrada.nextInt();
                    entrada.nextLine();

                    sistema.cancelarPedido(idCancelar);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        entrada.close();
    }

    private static void cadastrarCliente(SistemaProducao sistema, Scanner entrada) {
        System.out.print("ID do cliente: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();

        System.out.print("Email: ");
        String email = entrada.nextLine();

        System.out.print("Endereço: ");
        String endereco = entrada.nextLine();

        System.out.print("Observações: ");
        String observacoes = entrada.nextLine();

        Cliente cliente = new Cliente(id, nome, telefone, email, endereco, observacoes);
        sistema.cadastrarCliente(cliente);

        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void cadastrarModelo(SistemaProducao sistema, Scanner entrada) {
        System.out.print("ID do modelo: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nome do modelo: ");
        String nome = entrada.nextLine();

        System.out.print("Descrição: ");
        String descricao = entrada.nextLine();

        ModeloTerno modelo = new ModeloTerno(id, nome, descricao);
        sistema.cadastrarModelo(modelo);

        System.out.println("Modelo cadastrado com sucesso.");
    }

    private static void cadastrarPedido(SistemaProducao sistema, Scanner entrada) {
        System.out.print("ID do pedido: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("ID do cliente: ");
        int idCliente = entrada.nextInt();
        entrada.nextLine();

        Cliente cliente = null;
        for (Cliente c : sistema.getClientes()) {
            if (c.getId() == idCliente) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado. Cadastre o cliente primeiro.");
            return;
        }

        System.out.print("ID do modelo: ");
        int idModelo = entrada.nextInt();
        entrada.nextLine();

        ModeloTerno modelo = null;
        for (ModeloTerno m : sistema.getModelos()) {
            if (m.getId() == idModelo) {
                modelo = m;
                break;
            }
        }

        if (modelo == null) {
            System.out.println("Modelo não encontrado. Cadastre o modelo primeiro.");
            return;
        }

        System.out.print("Quantidade: ");
        int quantidade = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Tamanho: ");
        String tamanho = entrada.nextLine();

        System.out.print("Cor: ");
        String cor = entrada.nextLine();

        System.out.print("Tecido: ");
        String tecido = entrada.nextLine();

        System.out.print("Status: ");
        String status = entrada.nextLine();

        System.out.print("Data prevista de entrega (AAAA-MM-DD): ");
        String dataEntregaTexto = entrada.nextLine();
        LocalDate dataPrevistaEntrega = LocalDate.parse(dataEntregaTexto);

        System.out.print("Observações: ");
        String observacoes = entrada.nextLine();

        Pedido pedido = new Pedido(
                id,
                cliente,
                modelo,
                quantidade,
                tamanho,
                cor,
                tecido,
                status,
                LocalDate.now(),
                dataPrevistaEntrega,
                observacoes
        );

        sistema.cadastrarPedido(pedido);

        System.out.println("Pedido cadastrado com sucesso!");
    }
}