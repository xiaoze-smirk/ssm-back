package xiao.ze.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xiao.ze.demo.entity.User;
import xiao.ze.demo.service.UserService;

/**
 * SecurityController
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private UserService userService ;

    @PostMapping(value="/login")
    public String login(User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if(userService.get(user.getUserNo())!=null){
            User user1=userService.get(user.getUserNo());
            if(user1.getUserPwd().equals(user.getUserPwd())){
                String str= mapper.writeValueAsString(user1);
                return str;
            }
        }
        return "0";
    }

}