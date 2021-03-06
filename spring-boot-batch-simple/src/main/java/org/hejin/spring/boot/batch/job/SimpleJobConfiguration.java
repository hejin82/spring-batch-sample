package org.hejin.spring.boot.batch.job;

import org.hejin.spring.boot.batch.item.DummyItemReader;
import org.hejin.spring.boot.batch.item.LogItemProcessor;
import org.hejin.spring.boot.batch.item.LogItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job1").start(step()).build();
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("job1.step1").<String, String>chunk(1).reader(reader())
                .processor(processor()).writer(writer()).build();
    }

    @Bean
    public LogItemWriter writer() {
        return new LogItemWriter();
    }

    @Bean
    public LogItemProcessor processor() {
        return new LogItemProcessor();
    }

    @Bean
    public DummyItemReader reader() {
        return new DummyItemReader();
    }

}
