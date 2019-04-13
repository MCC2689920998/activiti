package com.weshare.phoenix.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author MCC
 * @Create 2019/4/12 14:01
 */
@ConfigurationProperties("weshare.process.config")
@Component
@Data
public class WeShareProcessProperties {

    private String flowChartPath="processcfg/bpmn/";
    private String flowChartName="";

    @Override
    public String toString() {
        return flowChartPath + flowChartName +".bpmn";
    }
}
