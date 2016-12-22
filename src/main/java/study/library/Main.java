package study.library;

import study.library.util.Server;

/**
 * Created by yauhen on 19.12.16.
 */
public class Main {


    public static void main(String[] args) {
        final Server server = new Server();

        try {

            server.startServer();
            System.in.read();
            server.stopServer();
        } catch (Exception e) {

            //TODO:DEBUG
            e.printStackTrace();
        }


    }
}
