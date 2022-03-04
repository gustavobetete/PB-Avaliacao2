import java.sql.*;

public class ProdutoDAO {

    public void inserir() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/LOJA1?useTimezone=true&serverTimezone=UTC", "root", "root");

        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.getConnection();

        Statement stm = con.createStatement();

        stm.execute("DROP TABLE IF EXISTS PRODUTO");
        stm.execute("CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), quantidade INT, preco FLOAT, PRIMARY KEY (id)) Engine = InnoDB;");
        stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO, QUANTIDADE, PRECO) VALUES ('Mouse', 'Mouse sem fio', 5, 69.90)");
        stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES ('Placa de video', 'Geforce 1060', 3, 3200.00)");
        stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES ('Teclado Mêcanico', 'Blackwindow Razer', 10, 500.00)");

        con.close();
    }
    public void listar() throws SQLException{
        ConnectionFactory ConnectionFactory = new ConnectionFactory();
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO, QUANTIDADE, PRECO FROM PRODUTO");
        stm.execute();

        ResultSet rst = stm.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("ID");
            System.out.println("id: " + id);
            String nome = rst.getString("NOME");
            System.out.println("Nome: " + nome);
            String descricao = rst.getString("DESCRICAO");
            System.out.println("Descrição: "+descricao);
            int quantidade = rst.getInt("QUANTIDADE");
            System.out.println("Quantidade: " +quantidade);
            double preco = rst.getDouble("PRECO");
            System.out.println("Preço R$: "+preco);
            System.out.println("------------------------");
        }

        con.close();
    }

}

