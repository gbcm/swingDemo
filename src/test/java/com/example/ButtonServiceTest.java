package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import javax.swing.*;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class ButtonServiceTest {

    @InjectMocks
    ButtonService subject;

    @Test
    public void providesButtonThatIncrementsText() throws Exception {
        JButton button = subject.getButton();
        assertEquals("Hello World!", button.getText());
        button.doClick();
        assertEquals("Button pressed 1 times", button.getText());
        button.doClick();
        button.doClick();
        assertEquals("Button pressed 3 times", button.getText());
    }

}