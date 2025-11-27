package br.com.ifba;


import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestaConexaoRunne implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- [INICIANDO TESTE DE CONEXAO SPRING] ---");
        
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1000)) {
                System.out.println(">>> SUCESSO! Conexão com o banco de dados estabelecida.");
                System.out.println("URL do Banco: " + connection.getMetaData().getURL());
            }
        } catch (Exception e) {
            System.out.println(">>> FALHA! O Spring não conseguiu conectar.");
            e.printStackTrace();
        }
        
        System.out.println("-------------------------------------------");
    }
}