package com.luddwg;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String path = args[0];
        LOGGER.info("Start analyze for %s directory".formatted(path));

        Executor executor = new Executor();
        LOGGER.info(executor.execute(path));
    }
}
