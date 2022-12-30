package com.gustavonascimento.horaDoDuelo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	 private ApiInfo informacoesApi() 
	    {
	    	ApiInfo apiInfo=new ApiInfo("Estudo sobre Spring Boot", "Criação de uma API  de comparação de cartas, com tema livre, onde deverá ser possível enviar duas cartas para a aplicação fazer uma comparação de atributos e a carta com a maior quantidade de atributos fortes será a vencedora.\n"
	    			+ "O que ela dispõe:\n Operações para cadastro, listagem, consulta e alteração de cartas;\r\n"
	    			+ "Operações para comparação de cartas e resultado acumulado;\r\n"
	    			+ "Banco de dados para armazenar as cartas e os resultados das comparações;\n Operação de exclusão de cartas.", "1.0", "Term of service", new Contact("Gustavo Henrique", "https://www.linkedin.com/in/gustavo-henrique-java/", "gustavohgustavo@hotmail.com"), "Apache License Version 2.0","https://www.apache.org/licenses/LICENSE-2.0",new ArrayList<>());
	    	return apiInfo;
	    }

	    @Bean
	    Docket detalheApi()
	    {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(informacoesApi());
	    }
}