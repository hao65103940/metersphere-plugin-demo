package com.metersphere.plugin.demo.util;

import io.metersphere.plugin.core.MsTestElement;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author fit2cloudzhao
 * @date 2024/3/20 11:35
 * @description:
 */
public class ElementUtil {


    public static String getFullIndexPath(MsTestElement element, String path) {
        if (element == null || element.getParent() == null) {
            return path;
        }
        path = element.getIndex() + "_" + path;
        return getFullIndexPath(element.getParent(), path);
    }

    public static void getScenarioSet(MsTestElement element, List<String> id_names) {
        if (StringUtils.equals(element.getType(), "scenario")) {
            id_names.add(element.getResourceId() + "_" + element.getName());
        }
        if (element.getParent() == null) {
            return;
        }
        getScenarioSet(element.getParent(), id_names);
    }


}
