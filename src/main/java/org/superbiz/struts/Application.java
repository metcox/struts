package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public FilterRegistrationBean SiteMeshFilterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        Filter filter = new SiteMeshFilter();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean strutsFilterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        Filter filter = new StrutsPrepareAndExecuteFilter();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns("/",
                "/addUserForm.action",
                "/addUser.action",
                "/findUserForm.action",
                "/findUser.action",
                "/listAllUsers.action");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

}
