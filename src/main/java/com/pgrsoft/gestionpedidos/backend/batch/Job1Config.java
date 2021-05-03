package com.pgrsoft.gestionpedidos.backend.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;

@Configuration
@EnableBatchProcessing
public class Job1Config {

	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    public DataSource dataSource;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<Camarero> reader() {
  
    	FlatFileItemReaderBuilder<Camarero>  flatFileItemReaderBuilder = new FlatFileItemReaderBuilder<Camarero>();
    	FlatFileItemReader<Camarero> flatFileItemReader = null;
    	
    	ClassPathResource classPathResource = new ClassPathResource("csv/camareros-to-database.csv");
    	
    	BeanWrapperFieldSetMapper<Camarero> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<Camarero>();
    	beanWrapperFieldSetMapper.setTargetType(Camarero.class);
    	
    	flatFileItemReaderBuilder
    		.name("camareroItemReader")
    		.resource(classPathResource)
    		.delimited()
    			.names(new String[] {"id", "nombre"})					//nombre de los campos
    			.fieldSetMapper(beanWrapperFieldSetMapper).build();
    	
    	flatFileItemReader = flatFileItemReaderBuilder.build();
    	
    	return flatFileItemReader;	
    }
    
    @Bean
    public CamareroItemProcessor processor() {
    	return new CamareroItemProcessor();
    }
    
    @Bean
    public JdbcBatchItemWriter<Camarero> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Camarero>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO camareros (ID, NOMBRE) VALUES (:id, :nombre)")
            .dataSource(dataSource)
            .build();
    }
    // end::readerprocessorwriter[]
     

    // tag::jobstep[]
    @Bean(name="importCamareroJob")
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importCamareroJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean(name="step1")
    public Step step1(JdbcBatchItemWriter<Camarero> writer) {
        return stepBuilderFactory.get("step1")
            .<Camarero, Camarero> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
    // end::jobstep[]
    

}
