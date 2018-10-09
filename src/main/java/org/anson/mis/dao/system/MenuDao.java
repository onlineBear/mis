package org.anson.mis.dao.system;

import org.anson.mis.entity.system.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDao extends JpaRepository<Menu, Long> {
}
