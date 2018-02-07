package com.fred.fix.sync.monitor;

public class DeviceOnlineVo {

    /**
     * appVersion : 6.0
     * clientId : cc8d92a9b59f54f8
     * connectionStatus : ONLINE
     * netWorkType : ETHERNET
     */

    private String appVersion;
    private String clientId;
    private String connectionStatus;
    private String netWorkType;

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public String getNetWorkType() {
        return netWorkType;
    }

    public void setNetWorkType(String netWorkType) {
        this.netWorkType = netWorkType;
    }
}
