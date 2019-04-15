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
public class BaseNodeInfoCfg extends BaseEntity {

    @Column(length = 64)
    private String nodeCode;


    @Column(length = 64)
    private String parentNodeCode;

    @Column(length = 64)
    private String processCode;

    @Column(length = 256)
    private String nodeDescription;
}
