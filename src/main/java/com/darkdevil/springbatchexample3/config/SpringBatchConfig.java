package com.darkdevil.springbatchexample3.config;

import com.darkdevil.springbatchexample3.model.Customer;
import com.darkdevil.springbatchexample3.model.CustomerBackUp;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Autowired
    public DataSource dataSource;

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<CustomerBackUp> itemReader,
                   ItemProcessor<CustomerBackUp, CustomerBackUp> itemProcessor,
                   ItemWriter<CustomerBackUp> itemWriter) {

        Step step = stepBuilderFactory.get("ETL-file-load")
                .<CustomerBackUp, CustomerBackUp>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        Job job = jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();

        return job;
    }

    @Bean
    public JdbcCursorItemReader<CustomerBackUp> itemReader(@Value("${query-listAllCustomersNotInCustomerBackUp}") String query) {
        JdbcCursorItemReader<CustomerBackUp> reader = new JdbcCursorItemReader<CustomerBackUp>();
        reader.setDataSource(dataSource);
        reader.setSql(query);
        reader.setRowMapper(new CustomerRowMapper());

        return reader;
    }

    public class CustomerRowMapper implements RowMapper<CustomerBackUp> {
        @Override
        public CustomerBackUp mapRow(ResultSet rs, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));

            System.out.println("Customer: " + customer.toString());

            CustomerBackUp customerBackUp = new CustomerBackUp();
            customerBackUp.setId(0);
            customerBackUp.setName(rs.getString("name"));

            System.out.println("CustomerBackUp: " + customerBackUp.toString());

            return customerBackUp;
        }
    }
}
/*
*   First we create the base class
*   Then we create the job
*   Then we create the steps
*   Then we create the item reader, item processor, item writer
*   Then we implement item reader, item processor, item writer
* */