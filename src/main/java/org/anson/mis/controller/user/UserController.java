package org.anson.mis.controller.user;

import org.anson.mis.framework.entity.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/user/1")
    public Response test(@RequestBody(required=true) String json){
        return Response.ok();
    }
}
