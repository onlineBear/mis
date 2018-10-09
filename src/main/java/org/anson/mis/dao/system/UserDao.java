package org.anson.mis.dao.system;

import org.anson.mis.entity.system.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
