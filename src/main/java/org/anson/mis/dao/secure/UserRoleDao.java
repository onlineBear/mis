package org.anson.mis.dao.secure;

import org.anson.mis.entity.secure.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole, Long> {
}
