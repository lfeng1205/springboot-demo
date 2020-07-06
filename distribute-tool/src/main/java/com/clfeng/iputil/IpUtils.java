package com.clfeng.iputil;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qian
 */
public class IpUtils {

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || StringUtils.isBlank(ip)
                || StringUtils.equalsIgnoreCase("unkonwn", ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ip) || StringUtils.isBlank(ip)
                || StringUtils.equalsIgnoreCase("unkonwn", ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ip) || StringUtils.isBlank(ip)
                || StringUtils.equalsIgnoreCase("unkonwn", ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (StringUtils.isEmpty(ip) || StringUtils.isBlank(ip)
                || StringUtils.equalsIgnoreCase("unkonwn", ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (StringUtils.isEmpty(ip) || StringUtils.isBlank(ip)
                || StringUtils.equalsIgnoreCase("unkonwn", ip)) {
            ip = request.getRemoteAddr();
        }


        return ip;
    }
}
