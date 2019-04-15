package com.weshare.phoenix.dao.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * @Author MCC
 * @Create 2019/4/15 17:51
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseNodeStorageCfg extends BaseEntity {

    @Column(length = 64)
    private String nodeCode;
    @Column(length = 128)
    private String storageCode;
    @Column(length = 256)
    private String storageDescription;
    @Column(length = 32)
    private int sequence;
}
