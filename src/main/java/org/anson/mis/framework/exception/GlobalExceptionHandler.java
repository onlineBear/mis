package org.anson.mis.framework.exception;

import org.anson.mis.framework.constant.enums.ResponseEnum;
import org.anson.mis.framework.entity.Response;
import org.anson.mis.framework.exception.entity.ClientException;
import org.anson.mis.framework.exception.entity.ServerException;
import org.apache.catalina.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handle(Exception e){

        Response res = new Response();
        res.setData(null);

        // 自定义错误
        if (e instanceof ClientException){
            ClientException clientException = (ClientException)e;
            res.setCode(ResponseEnum.CLIENT_ERROR);
            res.setMsg(clientException.getMsg());
        }else if (e instanceof HttpMessageNotReadableException) {
            res.setCode(ResponseEnum.SERVER_ERROR);
            res.setMsg("Please enter the json parameter");
        }else if (e instanceof NoHandlerFoundException){
            res.setCode(ResponseEnum.NOT_FOUND);
            res.setMsg("No handler found");
        }

        // 服务端错误
        else if(e instanceof ServerException){
            ServerException serverException = (ServerException)e;
            res.setCode(ResponseEnum.SERVER_ERROR);
            res.setMsg(serverException.getMsg());
        }

        // sql错误
        else if (e instanceof DuplicateKeyException || e instanceof UncategorizedSQLException
                || e instanceof CleanupFailureDataAccessException || e instanceof DataAccessResourceFailureException || e instanceof DataIntegrityViolationException
                || e instanceof DataRetrievalFailureException || e instanceof DeadlockLoserDataAccessException || e instanceof IncorrectUpdateSemanticsDataAccessException
                || e instanceof OptimisticLockingFailureException || e instanceof UncategorizedDataAccessException || e instanceof BadSqlGrammarException) {
            res.setCode(ResponseEnum.SERVER_ERROR);
            res.setMsg(e.getCause().getMessage());
        }else {
            res.setCode(ResponseEnum.SERVER_ERROR);
            res.setMsg(e.toString());
        }

        logger.error(e.toString());

        if (logger.isInfoEnabled()) {
            e.printStackTrace();
        }

        return res;
    }
}
