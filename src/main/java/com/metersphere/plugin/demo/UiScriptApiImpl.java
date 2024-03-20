package com.metersphere.plugin.demo;

import com.alibaba.fastjson.JSON;
import com.metersphere.plugin.demo.sampler.DemoRequest;
import io.metersphere.plugin.core.api.UiScriptApi;
import io.metersphere.plugin.core.ui.PluginResource;
import io.metersphere.plugin.core.ui.UiScript;
import io.metersphere.plugin.core.utils.LogUtil;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fit2cloudzhao
 * @date 2024/3/20 11:32
 * @description:
 */
public class UiScriptApiImpl extends UiScriptApi {

    public boolean xpack() {
        return false;
    }


    @Override
    public PluginResource init() {

        LogUtil.info("开始初始化脚本内容 1");
        List<UiScript> uiScripts = new LinkedList<>();
        String script = getJson("/json/ui_demo.json");
        UiScript uiScript = new UiScript("JmeterSampler", "JmeterSampler 调试","" , script);
        uiScript.setJmeterClazz("AbstractSampler");
        //添加可选参数
        uiScript.setFormOption(getJson("/json/ui_form.json"));

        uiScripts.add(uiScript);
        LogUtil.info("初始化脚本内容结束 1");
        return new PluginResource("DemoSampler-v1.0.1", uiScripts);
    }

    @Override
    public String customMethod(String s) {
        LogUtil.info("执行 MyThriftClientSampler 插件中的自定义方法");
        LogUtil.info("进入自定义方法 ,开始写自己的逻辑吧");
        List<DemoRequest> list = new LinkedList<>();
        DemoRequest argsParams = new DemoRequest();
        argsParams.setServerIp("127.0.0.1");
        argsParams.setServerPort(9099);
        argsParams.setRequestParam("哈哈");
        list.add(argsParams);
        LogUtil.info("customMethod==>" + JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }

    public String getJson(String path) {
        try {
            InputStream in = UiScriptApiImpl.class.getResourceAsStream(path);
            String json = org.apache.commons.io.IOUtils.toString(in);
            return json;
        } catch (Exception ex) {
            LogUtil.error(ex.getMessage());
        }
        return null;
    }

    public static String test() {
        return "success";
    }
}
