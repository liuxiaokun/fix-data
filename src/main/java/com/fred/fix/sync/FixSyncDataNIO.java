package com.fred.fix.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FixSyncDataNIO {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixSyncDataNIO.class);

    public static void main(String[] args) throws InterruptedException, IOException {

        String fileName = "E:\\fixsync\\src\\main\\resources\\data.txt";
        String charset = "UTF-8";
        LOGGER.info("charset={}", charset);

        List<String> lines = Files.readAllLines(Paths.get(fileName),
                Charset.forName(charset));

        for (String line : lines) {
            LOGGER.info(line);
            Thread.sleep(10000);
        }
    }
}
