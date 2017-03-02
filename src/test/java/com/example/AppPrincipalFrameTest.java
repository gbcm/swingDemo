package com.example;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppPrincipalFrameTest {

    private FrameFixture window;

    private static ConfigurableApplicationContext context;

    @BeforeClass
    public static void earlySetup() {
        System.setProperty("java.awt.headless", "false");
        context = new SpringApplicationBuilder(SwingDemoApplication.class).run();
    }


    @Before
    public void setup() {
        AppPrincipalFrame frame = GuiActionRunner.execute(() ->
                context.getBean(AppPrincipalFrame.class));
        window = new FrameFixture(frame);
        window.show();
    }


    @Test
    public void hasAButton() throws Exception {
        window.button("Incrementer").requireText("Hello World!");
        window.button("Incrementer").click();
        window.button("Incrementer").requireText("Button pressed 1 times");
        window.button("Incrementer").click();
        window.button("Incrementer").click();
        window.button("Incrementer").click();
        window.button("Incrementer").requireText("Button pressed 4 times");
    }
}