package com.siwoo.springboot.config;

import com.siwoo.springboot.shop.*;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Path;

@Configuration
@ComponentScan(basePackages = "com.siwoo.springboot.shop")
@PropertySource("classpath:config/discount.properties")
public class ShopConfiguration {

    @Value("${discount.endofyear}")
    private double discount;

    @Value("classpath:config/banner.txt")
    private Resource resource;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages/alert-messages");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cashier cashier() throws IOException {
        Cashier cashier = new Cashier();
        Path path = new ClassPathResource("/").getFile().toPath();
        path = path.resolve("shop");
        cashier.setPath(path);
        return cashier;
    }
    @Bean
    public BannerLoader bannerLoader() {
        BannerLoader banner = new ConsoleBannerLoader(resource);
        return banner;
    }

    @Bean
    @Primary
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart protoShoppingCart() {
        return new ShoppingCart();
    }

    @Bean
    public Product aaa() {
        Battery battery = new Battery("AAA", 2.5);
        battery.setRechargeable(true);
        return battery;
    }

    @Bean
    public Product cdrw() {
        Disc cdrw = new Disc("CD-RW", 1.5, discount);
        cdrw.setCapacity(700);
        return cdrw;
    }

    @Bean
    public Product dvdrw() {
        Disc dvd = new Disc("DVD-RW", 3.0);
        dvd.setCapacity(700);
        return dvd;
    }
}
