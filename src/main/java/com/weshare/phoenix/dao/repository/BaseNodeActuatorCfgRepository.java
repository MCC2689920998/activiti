package com.weshare.phoenix.dao.repository;

import com.weshare.phoenix.dao.entity.BaseNodeActuatorCfg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author MCC
 * @Create 2019/4/12 14:36
 */
public interface BaseNodeActuatorCfgRepository extends JpaRepository<BaseNodeActuatorCfg,Long> {

    List<BaseNodeActuatorCfg> findBaseNodeActuatorCfgsByNodeCode(String nodeCode);

}
