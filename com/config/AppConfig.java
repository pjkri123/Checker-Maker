package com.config;

import com.model.entity.Customer;
import com.model.entity.CustomerMaster;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.util.Locale;
import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan( "com" )

@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
        managerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        managerDataSource.setUrl("jdbc:oracle:thin:@10.1.50.198:1535/nsbt19c");
        managerDataSource.setUsername("training");
        managerDataSource.setPassword("training");
        return managerDataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactoryBean() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
//        props.put("hibernate.hbm2ddl.auto","create");
        props.put("hibernate.show_sql", "true");

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        sessionFactoryBean.setHibernateProperties(props);
        sessionFactoryBean.setAnnotatedClasses(Customer.class, CustomerMaster.class);
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager getManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactoryBean().getObject());
        return transactionManager;
    }

    @Bean
    public HibernateTemplate template() {
        HibernateTemplate template = new HibernateTemplate();
        template.setSessionFactory(getSessionFactoryBean().getObject());
        return template;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.setBasename("messages");
        return resource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        registry.addInterceptor(localeChangeInterceptor);
    }

    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setCookieName("my-locale-cookie");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
    }

}
