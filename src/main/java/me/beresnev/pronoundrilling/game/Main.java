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

        /*FileParser fileParser = applicationContext.getBean(FileParser.class);
        Path verbList = Paths.get("/home/ignat/Documents/Java/IDEA Projects/PronounTraining/src/main/resources/verbs");
        Path pronounList = Paths.get("/home/ignat/Documents/Java/IDEA Projects/PronounTraining/src/main/resources/pronouns");

        MySqlWordsDao mySqlWordsDao = applicationContext.getBean(MySqlWordsDao.class);
        System.out.println("Inserting verbs");
        mySqlWordsDao.insertVerbs(fileParser.parseVerbs(verbList));
        System.out.println("Inserting pronouns");
        mySqlWordsDao.insertPronouns(fileParser.parsePronouns(pronounList));*/

        GameStarter gameStarter = applicationContext.getBean(GameStarter.class);
        gameStarter.startTheGame();
    }
}
