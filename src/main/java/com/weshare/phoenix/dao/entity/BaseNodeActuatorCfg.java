package com.weshare.phoenix.dao.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * @Author MCC
 * @Create 2019/4/15 17:41
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseNodeActuatorCfg extends BaseEntity {

    @Column(length = 64)
    private String nodeCode;

    @Column(length = 128)
    private String actuatorCode;
    @Column(length = 256)
    private String actuatorDescription;
    @Column(length = 32)
    private int sequence;

}
