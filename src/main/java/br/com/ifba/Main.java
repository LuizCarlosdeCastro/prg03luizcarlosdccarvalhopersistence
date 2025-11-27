package br.com.ifba;
import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class Main {
    
    
    public static void main(String[] args) {
        
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(Main.class)
                .headless(false)
                .run(args);
        
        CursoListar telaCursoSave = context.getBean(CursoListar.class);
        telaCursoSave.setVisible(true);
        
        
    }
  
}