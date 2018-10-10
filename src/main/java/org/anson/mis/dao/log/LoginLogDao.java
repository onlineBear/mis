package org.anson.mis.dao.log;

import org.anson.mis.entity.log.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogDao extends JpaRepository<LoginLog, Long> {
}
