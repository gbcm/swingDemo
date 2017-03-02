package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class AppPrincipalFrame extends JFrame{

    @Autowired
    private ButtonService buttonService;

    @PostConstruct
    private void assembleFrame() {
        add(buttonService.getButton());
        pack();
    }
}
