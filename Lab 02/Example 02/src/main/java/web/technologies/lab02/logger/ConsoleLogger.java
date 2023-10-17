package web.technologies.lab02.logger;

public class ConsoleLogger implements ActionLogger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }

}
