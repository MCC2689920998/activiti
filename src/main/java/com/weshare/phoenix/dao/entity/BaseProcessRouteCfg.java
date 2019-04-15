package com.weshare.phoenix.dao.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * @Author MCC
 * @Create 2019/4/15 16:23
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseProcessRouteCfg extends BaseEntity {

    @Column(length = 64)
    private String channelCode;
    @Column(length = 64)
    private String productCode;
    @Column(length = 64)
    private String processCode;


}
