package com.siwoo.springboot.shop;

import com.siwoo.springboot.config.DaoConfiguration;
import com.siwoo.springboot.config.ShopConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;


@Configuration
public class TestShop {

    ApplicationContext c;

    @Before
    public void init() {
        c = new AnnotationConfigApplicationContext(ShopConfiguration.class);
    }

    @Test
    public void testMessageBundle() {
        String message = c.getMessage("alert.checkout", null, Locale.US);
        assertThat(message).isNotEmpty();
        System.out.println(message);
        message = c.getMessage("alert.inventory.checkout", new String[]{"CD-RW", LocalDateTime.now().toString()}, Locale.US);
        assertThat(message).isNotEmpty();

        ShoppingCart shoppingCart = c.getBean(ShoppingCart.class);
        Product aaa = c.getBean("aaa", Product.class);
        Product cdrw = c.getBean("cdrw", Product.class);
        Product dvdrw = c.getBean("dvdrw", Product.class);
        shoppingCart.addItem(aaa);
        shoppingCart.addItem(cdrw);
        shoppingCart.addItem(dvdrw);
        c.getBean(Cashier.class).checkout(shoppingCart);
    }

    @Test
    public void testResource() {
        c.getBean(BannerLoader.class).load();
    }

    @Test
    public void testProperties() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("config/discount.properties"));
        assertThat(c.getBean("cdrw", Disc.class).getDiscount()).isEqualTo(
                Double.parseDouble((String) properties.get("discount.endofyear")));
    }

    @Test
    public void testProducts() {
        assertThat(c.getBean("aaa", Product.class)).isNotNull();
        assertThat(c.getBean("cdrw", Product.class)).isNotNull();
        System.out.println(c.getBean("aaa"));
        System.out.println(c.getBean("cdrw"));
    }

    @Test
    public void testPrototype() {
        ShoppingCart shoppingCart = c.getBean(ShoppingCart.class);
        Product aaa = c.getBean("aaa", Product.class);
        Product cdrw = c.getBean("cdrw", Product.class);
        Product dvdrw = c.getBean("dvdrw", Product.class);
        shoppingCart.addItem(aaa);
        shoppingCart.addItem(cdrw);
        shoppingCart = c.getBean(ShoppingCart.class);
        shoppingCart.addItem(dvdrw);
        assertThat(shoppingCart.getItems()).contains(aaa, cdrw, dvdrw);

        ShoppingCart protoCart = c.getBean("protoShoppingCart", ShoppingCart.class);
        protoCart.addItem(aaa);
        protoCart.addItem(cdrw);
        assertThat(protoCart.getItems()).contains(aaa, cdrw);
        protoCart = c.getBean(ShoppingCart.class);
        protoCart.addItem(dvdrw);
        assertThat(protoCart.getItems()).contains(dvdrw);
    }
}
