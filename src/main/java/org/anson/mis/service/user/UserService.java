package org.anson.mis.service.user;

import org.anson.mis.dao.log.LoginLogDao;
import org.anson.mis.dao.system.UserDao;
import org.anson.mis.entity.log.LoginLog;
import org.anson.mis.entity.system.User;
import org.anson.mis.entity.web.Response;
import org.anson.mis.util.datatype.StringUtil;
import org.anson.mis.util.id.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * 登录
     * @param userNo
     * @param password
     */
    @Transactional
    public Response login(String userNo, String password){
        if(StringUtil.isEmpty(userNo)){
            throw new RuntimeException("请输入用户编码");
        }
        if(StringUtil.isEmpty(password)){
            throw new RuntimeException("请输入密码");
        }

        Date nowTime = new Date();

        User inputUser = dao.findByNo(userNo);

        if(inputUser == null){
            return Response.clienError("无此用户");
        }

        // 登录日志
        Long loginLogId = IdWorker.getId();

        LoginLog loginLog = new LoginLog();
        loginLog.setId(IdWorker.getId());
        loginLog.setUser(inputUser);
        loginLog.setSuccess(false);
        loginLog.convertNull2Default();

        loginLogDao.save(loginLog);

        String calPsd = password;
        inputUser = dao.findByNoAndPassword(userNo, calPsd);

        if(inputUser == null){
            return Response.clienError("密码不正确");
        }

        // 登录成功日志
        loginLog.setSuccess(true);
        loginLogDao.save(loginLog);
        return Response.ok();
    }

}
