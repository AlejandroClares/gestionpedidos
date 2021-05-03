package com.pgrsoft.gestionpedidos.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	      .addResourceHandler("/files/**")
	      .addResourceLocations("file:///C:/opt/files");
	    
	      // NO ESTA FUNCIONANDO!
	    
	      // localhost:8080/api/files/loquesea.jpg 
	      // funcionará si en c: existe una carpeta opt con una subcarpeta files con loquesea.jpg!
	    
	     registry
	     	.addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");
	 
	     registry
	     	.addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	  }	    
}
