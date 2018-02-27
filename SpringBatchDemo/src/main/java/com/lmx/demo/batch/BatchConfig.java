//package com.lmx.demo.batch;
//
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
///**
// * @author liumingxin
// * @create 2018 26 9:45
// * @desc
// **/
//@Configuration
//@EnableBatchProcessing
//public class BatchConfig {
//
//    // tag::readerwriterprocessor[]
//    @Bean
//    public FlatFileItemReader<Person> flatFileItemReader() {
//        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
//        reader.setResource(new ClassPathResource("sample-data.csv"));
//        FixedLengthTokenizer fixedLengthTokenizer = new FixedLengthTokenizer();
//        reader.setLineMapper(new DefaultLineMapper<Person>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[]{"firstName", "lastName"});
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                setTargetType(Person.class);
//            }});
//        }});
//        return reader;
//    }
//
//    @Bean
//    public JdbcPagingItemReader<Person> jdbcPagingItemReader(DataSource dataSource) {
//        JdbcPagingItemReader<Person> reader = new JdbcPagingItemReader<>();
//        reader.setDataSource(dataSource);
//        reader.setFetchSize(100);
//
//        reader.setQueryProvider(new MySqlPagingQueryProvider() {{
//            setSelectClause("SELECT person_id,first_name,last_name");
//            setFromClause("from people");
//            setWhereClause("last_name=:lastName");
//            setSortKeys(new HashMap<String, Order>() {{
//                put("person_id", Order.ASCENDING);
//            }});
//        }});
//        reader.setParameterValues(new HashMap<String, Object>() {{
//            put("lastName", "DOE");
//        }});
//        reader.setRowMapper(new BeanPropertyRowMapper<>(Person.class));
//        return reader;
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Person> jdbcBatchItemWriter(DataSource dataSource) {
//        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
//        writer.setDataSource(dataSource);
//        return writer;
//    }
//
//    /*@Bean
//    public FlatFileItemWriter<Person> flatFileItemWriter(DataSource dataSource) {
//        FlatFileItemWriter<Person> writer = new FlatFileItemWriter<>();
//        writer.setAppendAllowed(true);
//        writer.setEncoding("UTF-8");
////        writer.set(dataSource);
//        return writer;
//    }*/
//
//    // end::readerwriterprocessor[]
//
//    // tag::jobstep[]
//    @Bean
//    public Job importUserJob(JobBuilderFactory jobBuilderFactory, JobCompletionNotificationListener listener, Step step) {
//        return jobBuilderFactory.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .start(step)
//                .build();
//    }
//
//    @Bean
//    public Step step1(StepBuilderFactory stepBuilderFactory, PersonItemProcessor processor, ItemWriter jdbcBatchItemWriter, ItemReader flatFileItemReader) {
//        /*CompositeItemProcessor compositeItemProcessor = new CompositeItemProcessor();
//        compositeItemProcessor.setDelegates(Lists.newArrayList(processor, processor));*/
//        return stepBuilderFactory.get("step1")
//                .<Person, Person>chunk(10)
//                .reader(flatFileItemReader)
//                .processor(processor)
//                .writer(jdbcBatchItemWriter)
//                .build();
//    }
//    // end::jobstep[]
//}
