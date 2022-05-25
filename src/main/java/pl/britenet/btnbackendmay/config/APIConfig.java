package pl.britenet.btnbackendmay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.britenet.campus.service.ProductService;
import pl.britenet.campus.service.database.DatabaseService;

@Configuration
public class APIConfig {

    private final DatabaseService databaseService;

    @Autowired
    public APIConfig(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Bean
    public ProductService getProductService() {
        return new ProductService(this.databaseService);
    }
}
