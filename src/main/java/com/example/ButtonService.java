package com.example;

import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class ButtonService {

    private int count;

    private void pressButton() {
        count++;
    }

    private String getButtonName() {
        return count == 0 ? "Hello World!" : "Button pressed " + count + " times";
    }

    public JButton getButton() {
        JButton button = new JButton(getButtonName());
        button.setName("Incrementer");
        button.addActionListener(e -> {
            pressButton();
            button.setText(getButtonName());
        });
        return button;
    }
}
