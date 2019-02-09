package com.siwoo.springboot.shop;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Locale;

public class Cashier implements BeanNameAware {

    @Autowired
    private MessageSource messageSource;

    private Path path;

    private String fileName;

    private BufferedWriter out;

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public void setBeanName(String name) {
        this.fileName = name;
    }

    private void init() {
        try {
            if (!path.toFile().exists())
                path.toFile().mkdir();
            if (!path.resolve(fileName).toFile().exists())
                path.resolve(fileName).toFile().createNewFile();
            File file = path.resolve(fileName).toFile();
            out = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void destroy() {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkout(ShoppingCart cart) {
        try {
            String message = messageSource.getMessage("alert.inventory.checkout",
                    new Object[]{cart.getItems(), LocalDateTime.now()}, Locale.US);
            out.write(message);
            out.write(System.getProperty("line.separator"));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
