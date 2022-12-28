package dao;

import java.sql.*;

public class ModuloConexao {

    //Método reponsável por esatabelecer conexao com o banco

    public static Connection conector() { //"Connection" é um framework ou conjunto de funcionalidades que vem do pacote importado "java.sql".
        Connection conexao = null;
        //A linha abaixo instancia o driver importado.
        //String driver = "com.mysql.cj.jdbc.Driver"; --> já não é necessário escrever esta linha no java 17
        //A linha abaixo armazena informações referentes ao banco.
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "";
        //Estabelecendo a conexao com o Banco de dados.
        try {
            //Class.forName(driver); //--> já não é necessário escrever esta linha no java 17
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //A linha abixo serve de apoio para exclarecer o erro, caso surja. E esta mensagemn não é para o usuário
            //System.out.println(e);
            return null;
        }
    }
}
