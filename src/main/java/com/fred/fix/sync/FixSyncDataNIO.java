package com.fred.fix.sync;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FixSyncDataNIO {


    public static void main(String[] args) throws InterruptedException, IOException {


        String fileName = "E:\\fixsync\\src\\main\\resources\\data.txt";
        String charset = "UTF-8";
        System.out.println("charset=" + charset);

        List<String> lines = Files.readAllLines(Paths.get(fileName),
                Charset.forName(charset));

        for (String line : lines) {
            System.out.println(line);
            Thread.sleep(1000);
        }
    }
}
