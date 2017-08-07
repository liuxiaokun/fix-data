package com.fred.fix.sync;

import java.io.Serializable;
import java.util.List;

public class ResponseData implements Serializable {
    private static final long serialVersionUID = -3774488043040776441L;

    private int code;

    private String message;

    private String syncTime;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

}
