package kz.krieger.task_manager.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("api.holiday")
public class ApplicationProperties {
    private String url;
}
