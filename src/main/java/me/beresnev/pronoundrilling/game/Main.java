package me.beresnev.pronoundrilling.game;

import me.beresnev.pronoundrilling.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GameStarter gameStarter = applicationContext.getBean(GameStarter.class);
        gameStarter.startTheGame();
    }
}
