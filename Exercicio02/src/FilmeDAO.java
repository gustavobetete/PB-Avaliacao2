import java.sql.*;
import java.util.Scanner;

public class FilmeDAO {

    Scanner sc = new Scanner(System.in);

    ConnectionFactory factory = new ConnectionFactory();
    Connection con = factory.getConnection();

    public FilmeDAO() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/FILMES?useTimezone=true&serverTimezone=UTC", "root", "root");
    }

    public void inserir() throws SQLException {

        Statement stm = con.createStatement();

        //Limpando a tabela para iniciar sempre com uma nova e os ids serem sempre apartir do 1

        stm.execute("DROP TABLE IF EXISTS FILME");
        stm.execute("CREATE TABLE FILME (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), ano INT(4), PRIMARY KEY (id)) Engine = InnoDB;");

        // Adicionando 20 filmes

        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('O homem das trevas', 'Terror', 2016)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Alerta Vermelho', 'Comédia', 2021)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Harry Potter e o Cálice de fogo', 'Fantasia', 2005)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Venom', 'Ação', 2008)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Kings Man', 'Ação', 2021)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Tempo', 'Terror', 2015)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('King Richard', 'Drama', 1999)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Vidro', 'Drama', 2019)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Homem-Aranha', 'Ação', 2004)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Encanto', 'Comédia', 2020)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Velozes e Furiosos 9', 'Ação', 2021)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Nós', 'Terror', 2019)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('365 dni', 'Erótico', 2020)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('My son', 'Suspense', 2021)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('O mágico de Oz', 'Fantasia', 1994)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Venom 4', 'Ação', 2022)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Carrie - A estranha', 'Terror', 1976)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Hotel Transilvânia', 'Comédia', 2022)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Scott Pilgrim contra o mundo', 'Ação', 2010)");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Nosferatu', 'Terror', 1922)");

    }
    public void construcaoDePaginacao(int qtdFilmesPorPagina, int paginaAcessada) throws SQLException {

        inserir();
        int qtdFilmes = 20;

        double qtdPaginas = Math.ceil(qtdFilmes / (float)qtdFilmesPorPagina);

        listar(qtdFilmesPorPagina, paginaAcessada, (int) qtdPaginas);
    }

    public void listar(int qtdFilmesPorPagina, int paginaAcessada, int qtdDePaginasDisponiveis) throws SQLException{

        int contador = 1;
        int inicio = 0;
        int fim = 0;

        // Caso o usuario digite uma pagina que não existe, aparecerá um erro informando que a pagina não existe!
        if(qtdFilmesPorPagina < 1 || qtdFilmesPorPagina >20){
            System.out.println("-----------------------------------*----------------------------------");
            System.out.println("A quantidade de filmes disponivel é 20! Digite um numero de 1 a 20.");
            System.out.println("-----------------------------------*----------------------------------");
        }else {
            if(paginaAcessada < 1 || paginaAcessada > qtdDePaginasDisponiveis){
                System.out.println("Página não existente! ");
                System.out.println("páginas possíveis para ser acessada: " + qtdDePaginasDisponiveis + ". Pagina acessada: "+ paginaAcessada + ".");
                System.out.println("Você não passou uma pagina valida! Por favor insira novamente uma pagina valida!!! \n");
            }else{
                System.out.println("*----*----*");
                System.out.println("Página: " + paginaAcessada + "/" + qtdDePaginasDisponiveis);
                System.out.println("*----*----*");
                while(contador <= qtdDePaginasDisponiveis) {

                    if(paginaAcessada == contador){

                        inicio = ((qtdFilmesPorPagina * contador) - qtdFilmesPorPagina);
                        fim = qtdFilmesPorPagina;
                        break;
                    }

                    contador++;
                }
        }
            try(PreparedStatement ps = con.prepareStatement("SELECT * FROM FILME LIMIT ?, ?")){
                ps.setInt(1, inicio);
                ps.setInt(2, fim);
                ps.execute();

                try(ResultSet rst = ps.getResultSet()){

                    while(rst.next()){
                        System.out.println("------------*------------");
                        Integer id = rst.getInt("ID");
                        System.out.println("id: " + id);
                        String nome = rst.getString("NOME");
                        System.out.println("Nome: " + nome);
                        String descricao = rst.getString("DESCRICAO");
                        System.out.println("Descrição: "+descricao);
                        int ano = rst.getInt("ANO");
                        System.out.println("Ano: " +ano);
                        System.out.println("------------*------------");
                    }
                }
            }
        }
    }


}
