package sydney.hospital.report.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component
public class DbQueueConfig {

    private static final int NUM_OF_THREAD = 1;
    private static final String THREAD_NAME = "DB-";

    @Bean(name = "db")
    public Executor dbExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(NUM_OF_THREAD);
        executor.setMaxPoolSize(NUM_OF_THREAD);
        executor.setThreadNamePrefix(THREAD_NAME);
        executor.initialize();
        return executor;
    }
}
