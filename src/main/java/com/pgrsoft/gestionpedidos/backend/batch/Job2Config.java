package com.pgrsoft.gestionpedidos.backend.batch;

//@Configuration
//@EnableBatchProcessing
public class Job2Config {
/*	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    public DataSource dataSource;
 
    @Bean
    public JdbcCursorItemReader<Camarero> reader(){
    	JdbcCursorItemReader<Camarero> cursorItemReader = new JdbcCursorItemReader<>();
    	cursorItemReader.setDataSource(dataSource);
    	cursorItemReader.setSql("SELECT id, nombre FROM camareros");
    	cursorItemReader.setRowMapper(new CamareroRowMapper());
    	return cursorItemReader;
    }
    
    @Bean
    public CamareroItemProcessor processor() {
    	return new CamareroItemProcessor();
    }
    
    @Bean
    public FlatFileItemWriter<Camarero> writer(){
    
    	BeanWrapperFieldExtractor<Camarero> fieldExtractor = new BeanWrapperFieldExtractor<Camarero>();
    	fieldExtractor.setNames(new String[] {"id","nombre"});
    	
    	DelimitedLineAggregator<Camarero> lineAggregator = new DelimitedLineAggregator<Camarero>();
    	
    	lineAggregator.setDelimiter(",");
    	lineAggregator.setFieldExtractor(fieldExtractor);
    	
    	FlatFileItemWriter<Camarero> writer = new FlatFileItemWriter<Camarero>();
    	
    	writer.setResource(new ClassPathResource("camareros_from_database.csv"));
    	writer.setLineAggregator(lineAggregator);
   
    	return writer;
    }
    
    
    @Bean
    public Step step() {	
    	return stepBuilderFactory.get("step").<Camarero,Camarero>chunk(100)
    	.reader(reader())
    	.processor(processor())
    	.writer(writer())
    	.build();
    }
    
    @Bean(name="exportCamareroJob")
    public Job exportCamareroJob(JobCompletionNotificationListener listener, Step step) {
        return jobBuilderFactory.get("exportCamareroJob")
            .incrementer(new RunIdIncrementer())
       //     .listener(listener)
            .flow(step())
            .end()
            .build();
    }
    
*/   
}
