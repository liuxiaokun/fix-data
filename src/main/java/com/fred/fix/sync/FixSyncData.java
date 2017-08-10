package com.fred.fix.sync;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FixSyncData {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixSyncData.class);

    public static void main(String[] args) throws Exception {


        File ctoFile = new File("E:\\scenic\\fixsync\\src\\main\\resources\\data.txt");

        InputStreamReader rdCto = new InputStreamReader(new FileInputStream(ctoFile));

        BufferedReader bfReader = new BufferedReader(rdCto);

        String textLine = null;

        while ((textLine = bfReader.readLine()) != null) {

            System.out.println(textLine);
            final DataLineVo vo = JsonUtil.parseJson(textLine, DataLineVo.class);

            if (null == vo) {
                LOGGER.error("修复数据不对");
                continue;
            }
            LOGGER.info("修复数据-> 辅助码：{}", vo.getAddCode());
            final String logPrefix = "修复数据-> 辅助码：" + vo.getAddCode() + ":";
            System.out.println(logPrefix + "start");
            String result = ResClient.pass(vo);
            ResponseData responseData = new Gson().fromJson(result, ResponseData.class);

            if (responseData != null && responseData.getCode() == 0) {
                System.out.println(logPrefix + "success");
            } else {
                System.out.println("Failed :" + JsonUtil.toJson(vo));
            }
            Thread.sleep(2000);
        }

        bfReader.close();


    }

}
