package com.weshare.phoenix.dao.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * @Author MCC
 * @Create 2019/4/15 17:33
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseFlowChartCfg extends BaseEntity {

    @Column(length = 64)
    private String processCode;


    @Column(length = 64)
    private String flowChartDeployKey;



}
