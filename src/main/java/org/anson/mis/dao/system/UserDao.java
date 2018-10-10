package org.anson.mis.dao.system;

import org.anson.mis.entity.system.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    public User findByNo(String no);
    public User findByNoAndPassword(String no, String password);
}
