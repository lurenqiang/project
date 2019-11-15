package com.lurenqiang.car.Intercept;

import com.lurenqiang.car.Dao.UserMapper;
import com.lurenqiang.car.Vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequestMapping("login")
public class LoginController {
    private UserMapper userMapper;
    private LoginController(UserMapper userMapper){
        this.userMapper=userMapper;
    }
    @RequestMapping("/login_in")
    public String login() {
        return "login";
    }

    @RequestMapping("/verifyLogin")
    public ModelAndView verifyLogin(String name, String password,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = userMapper.selectByName(name);
        if(user == null){
            modelAndView.setViewName("login");
            modelAndView.addObject("msg","账号不存在");
            return modelAndView;
        }else if(!password.equals(user.getPassword())){
            modelAndView.setViewName("login");
            modelAndView.addObject("msg","密码错误");
            log.info(modelAndView.toString());
            return modelAndView;
        }else{
            session.setAttribute("user",user);
            session.setMaxInactiveInterval(100);
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }

    @RequestMapping("/quit")
    public String quit(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    
}
