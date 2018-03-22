package javase03.t01;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CrazyLogger logger = new CrazyLogger();

        logger.addToLog("Привет") ;
        logger.addToLog("Все плохо") ;
        logger.addToLog("Ошибка твоей жизни") ;
        logger.addToLog("Ошибка чужой жизни") ;

        System.out.println(logger.findInfoByString("Ошибка"));
    }
}
