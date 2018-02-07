package com.fred.fix.sync.monitor;

import com.fred.fix.sync.ResClient;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeviceMonitor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceMonitor.class);

    @Override
    public void run() {

        List<String> list = new ArrayList<>();

        list.add("fcc3c987b7886e81");
        list.add("665b1142236486dc");
        list.add("5f6d9cb6a6e97a18");
        list.add("319a8438b2ec1d06");
        list.add("e4d3fa438d8e3f9e");
        list.add("cc8d92a9b59f54f8");
        list.add("9dc4b7e6b638ef70");
        list.add("20eb5167fab657c8");
        list.add("a2daa063172eab90");
        list.add("f87ef0d159f289a5");
        list.add("a942f52434054952");

        for (String s : list) {
            String url = "http://super.lvmama.com/broker/monitor/getDeviceInfo.do?clientId=";
            url = url + s;

            String result = ResClient.get(url);
            LOGGER.debug(result);
            DeviceOnlineVo responseData = new Gson().fromJson(result, DeviceOnlineVo.class);

            if (null != responseData) {
                LOGGER.info("ClientId:{}, connectionStatus:{}", new Object[]{responseData.getClientId(), responseData.getConnectionStatus()});
            }
        }

        LOGGER.info("-------------------------------------------------------------------------------------------");

    }


    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new DeviceMonitor(), 0, 10, TimeUnit.MINUTES);
    }
}
