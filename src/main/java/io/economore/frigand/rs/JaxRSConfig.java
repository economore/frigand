package io.economore.frigand.rs;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

import static io.economore.frigand.rs.JaxRSConfig.PATH;

@Configuration
@ApplicationPath(PATH)
public class JaxRSConfig extends ResourceConfig {

    public static final String PATH = "/frigand";

    @PostConstruct
    public void postConstruct() {
        registerPackage(FritzUpdateEndpoint.class.getPackage().getName());
    }

    private void registerPackage(String packageName) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        registerClasses(scanner.findCandidateComponents(packageName).stream()
                .map(beanDefinition -> ClassUtils.resolveClassName(beanDefinition.getBeanClassName(), JaxRSConfig.class.getClassLoader()))
                .collect(Collectors.toSet()));
    }

}
