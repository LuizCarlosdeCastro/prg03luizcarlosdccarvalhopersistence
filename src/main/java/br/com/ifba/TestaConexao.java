import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestaConexao {

    public static void main(String[] args) {
        System.out.println("--- [INICIANDO TESTE DE CONEXÃO] ---");
        
        try {
            // O nome "gerenciamento_curso" DEVE ser o mesmo 
            // do <persistence-unit name="..."> no seu persistence.xml
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdaula");
            
            System.out.println(">>> SUCESSO! Conexão estabelecida e EntityManagerFactory criada.");
            
            emf.close();
            System.out.println("--- [TESTE FINALIZADO] ---");

        } catch (Exception e) {
            System.err.println(">>> FALHA! Não foi possível conectar ao banco.");
            System.err.println("Causa provável: URL, usuário, senha ou privilégios incorretos.");
            e.printStackTrace(); // Isso mostrará o erro exato
        }
    }
}