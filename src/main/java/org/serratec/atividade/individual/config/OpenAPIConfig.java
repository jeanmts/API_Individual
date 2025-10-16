package org.serratec.atividade.individual.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenApi() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Servidor local!");

        Contact contact = new Contact();
        contact.setEmail("matos.sd52@gmail.com");
        contact.setName("Jean matos");
        contact.setUrl("https://www.linkedin.com/in/-jeancarlos/");

        License apacheLicense = new License().name("Apache license Version 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info()
                .title("API - Controle de Manutenção de veiculos")
                .version("1.0")
                .contact(contact)
                .description("API desenvolvida para ter o controle de manutenções de veiculos")
                .termsOfService("https://www.serratec.org.br/")
                .license(apacheLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
