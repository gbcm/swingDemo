package com.example;

import com.sun.glass.ui.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

import java.lang.reflect.InvocationTargetException;

import static javax.swing.SwingUtilities.invokeAndWait;

@SpringBootApplication
public class SwingDemoApplication {

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SwingDemoApplication.class).headless(false).run(args);
        invokeAndWait(() -> {
            JFrame frame = context.getBean(AppPrincipalFrame.class);
            frame.setVisible(true);
        });
    }
}