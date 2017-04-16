package me.beresnev.pronoundrilling.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "me.beresnev.pronoundrilling")
@PropertySource("classpath:settings.properties")
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
    @Resource
    private Environment env;

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        logger.debug("ViewResolver initialized");
        return viewResolver;
    }

    @Bean
    @Qualifier("dataSource")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        logger.debug("BasicDataSource configured");
        return dataSource;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        logger.debug("Resource handler registered");
    }

    @Bean
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    /*
    * Leaving it here for the better days of when this application has localization
    * */

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLoggingFilter());
        logger.info("Interceptors registered");
    }*/

    /*@Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("/localeMessages/messages");
        logger.info("ResourceBundleMessageSource initialized");
        return messageSource;
    }

    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }*/
}
