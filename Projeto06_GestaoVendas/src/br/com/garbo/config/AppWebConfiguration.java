package br.com.garbo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.garbo.dao.ClientesDao;
import br.com.garbo.dao.ProdutosDao;

@EnableWebMvc
@ComponentScan(basePackages = "br.com.garbo.controllers")
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/db_vendas");
		dataSource.setUsername("root");
		dataSource.setPassword("admin123");
		
		return dataSource;
	}
	
	@Bean
	public ClientesDao getClientesDao() {
		return new ClientesDao(getDataSource());
	}
	
	@Bean
	public ProdutosDao getProdutosDao() {
		return new ProdutosDao(getDataSource());
	}
	
	//Utilizado para permitir acesso a dados do formulario multiplo (multi-part)
	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}
