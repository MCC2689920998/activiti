package com.weshare.phoenix.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author MCC
 * @Create 2019/4/15 16:24
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;

    @Column(length = 128)
    private String createBy;

    @Column(length = 128)
    private String updateBy;

    @CreatedDate
    private Date dateCreate;
    @LastModifiedDate
    private Date dateUpdate;


}
