package org.anson.mis.dao.secure;

import org.anson.mis.entity.secure.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
