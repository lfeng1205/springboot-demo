package com.clfeng.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author qian
 */
@Data
public class IpZone {

    private final String ip;
    private String mainInfo = "";
    private String subInfo = "";

    public IpZone(String ip) {
        this.ip = ip;
    }

    public String getMainInfo() {
        if (StringUtils.contains(mainInfo, "省")) {
            return mainInfo.substring(0, mainInfo.indexOf("省"));
        }
        if (StringUtils.contains(mainInfo, "市")) {
            return mainInfo.substring(0, mainInfo.indexOf("市"));
        }
        return mainInfo;
    }
}
