package vn.tiger.product.configs;

import com.tiger.cores.EnableCommonCore;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import vn.tiger.product.command.api.exceptions.ProductServiceEventsErrorHandler;
import vn.tiger.sagacommon.EnableSagaCore;

@Configuration
@EnableCommonCore
@EnableSagaCore
public class AppConfig {

    @Autowired
    public void configure(EventProcessingConfigurer configurer) {
        configurer.registerListenerInvocationErrorHandler("product", configuration -> new ProductServiceEventsErrorHandler());
    }
}
