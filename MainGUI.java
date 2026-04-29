import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame {

    private SistemaProducao sistema = new SistemaProducao();

    private JTextField campoNomeCliente;
    private JTextField campoTelefone;
    private JTextField campoNomeModelo;
    private JTextField campoQuantidade;
    private JTextField campoTamanho;
    private JTextField campoCor;
    private JTextField campoTecido;
    private JTextField campoDataEntrega;

    private JTable tabelaPedidos;
    private DefaultTableModel modeloTabela;

    private int idCliente = 1;
    private int idModelo = 1;
    private int idPedido = 1;

    public MainGUI() {
        setTitle("Sistema de Produção de Ternos");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(9, 2, 5, 5));

        campoNomeCliente = new JTextField();
        campoTelefone = new JTextField();
        campoNomeModelo = new JTextField();
        campoQuantidade = new JTextField();
        campoTamanho = new JTextField();
        campoCor = new JTextField();
        campoTecido = new JTextField();
        campoDataEntrega = new JTextField();

        painel.add(new JLabel("Nome do cliente:"));
        painel.add(campoNomeCliente);

        painel.add(new JLabel("Telefone:"));
        painel.add(campoTelefone);

        painel.add(new JLabel("Modelo do terno:"));
        painel.add(campoNomeModelo);

        painel.add(new JLabel("Quantidade:"));
        painel.add(campoQuantidade);

        painel.add(new JLabel("Tamanho:"));
        painel.add(campoTamanho);

        painel.add(new JLabel("Cor:"));
        painel.add(campoCor);

        painel.add(new JLabel("Tecido:"));
        painel.add(campoTecido);

        painel.add(new JLabel("Data entrega (AAAA-MM-DD):"));
        painel.add(campoDataEntrega);

        JButton botaoCadastrar = new JButton("Cadastrar pedido");
        painel.add(botaoCadastrar);

        String[] colunas = {
                "ID", "Cliente", "Telefone", "Modelo", "Qtd",
                "Tamanho", "Cor", "Tecido", "Status", "Entrega"
        };

        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaPedidos = new JTable(modeloTabela);

        add(painel, BorderLayout.NORTH);
        add(new JScrollPane(tabelaPedidos), BorderLayout.CENTER);

        botaoCadastrar.addActionListener(e -> cadastrarPedido());
    }

    private void cadastrarPedido() {
        try {
            Cliente cliente = new Cliente(
                    idCliente++,
                    campoNomeCliente.getText(),
                    campoTelefone.getText(),
                    "",
                    "",
                    ""
            );

            ModeloTerno modelo = new ModeloTerno(
                    idModelo++,
                    campoNomeModelo.getText(),
                    ""
            );

            Pedido pedido = new Pedido(
                    idPedido++,
                    cliente,
                    modelo,
                    Integer.parseInt(campoQuantidade.getText()),
                    campoTamanho.getText(),
                    campoCor.getText(),
                    campoTecido.getText(),
                    "Em produção",
                    LocalDate.now(),
                    LocalDate.parse(campoDataEntrega.getText()),
                    ""
            );

            sistema.cadastrarCliente(cliente);
            sistema.cadastrarModelo(modelo);
            sistema.cadastrarPedido(pedido);

            modeloTabela.addRow(new Object[]{
                    pedido.getId(),
                    cliente.getNome(),
                    cliente.getTelefone(),
                    modelo.getNome(),
                    pedido.getQuantidade(),
                    pedido.getTamanho(),
                    pedido.getCor(),
                    pedido.getTecido(),
                    pedido.getStatus(),
                    pedido.getDataPrevistaEntrega()
            });

            limparCampos();

            JOptionPane.showMessageDialog(this, "Pedido cadastrado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao cadastrar pedido. Verifique os campos.\n" + erro.getMessage()
            );
        }
    }

    private void limparCampos() {
        campoNomeCliente.setText("");
        campoTelefone.setText("");
        campoNomeModelo.setText("");
        campoQuantidade.setText("");
        campoTamanho.setText("");
        campoCor.setText("");
        campoTecido.setText("");
        campoDataEntrega.setText("");
    }

    public static void main(String[] args) {
        new MainGUI().setVisible(true);
    }
}