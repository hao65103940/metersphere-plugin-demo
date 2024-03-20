package com.metersphere.plugin.demo.sampler;

import lombok.Data;

/**
 * @author fit2cloudzhao
 * @date 2024/3/20 11:36
 * @description:
 */
@Data
public class DemoRequest {

    private String serverIp;

    private Integer serverPort;

    private String requestParam;
}
