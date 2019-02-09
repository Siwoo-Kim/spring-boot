package com.siwoo.springboot.shop;

import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.file.Files;


public class ConsoleBannerLoader implements BannerLoader {
    private Resource resource;

    public ConsoleBannerLoader(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void load() {
        try {
            Files.lines(resource.getFile().toPath()).forEachOrdered(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot find the file [ " + resource.getFilename() + " ].");
        }
//        try (Scanner scanner = new Scanner(new InputStreamReader(resource.getInputStream()))) {
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Cannot find the file [ " + resource.getFilename() + " ].");
//        }
    }
}
