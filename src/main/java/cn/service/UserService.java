package cn.service;

import cn.dao.UserMapper;
import cn.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Resource
    UserMapper userMapper;
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userMapper.getUser(s);
        if (user==null){
            throw  new UsernameNotFoundException("账户不存在");
        }
        user.setRoles(userMapper.getRole(user.getUid()));
        return user;
    }

    public List<User> getAll(){
        return userMapper.getAll();
    }
    public List<User> getUserName(String username,Integer enabled){
        return userMapper.getUserName(username,enabled);
    }
    public int delete(Integer uid){
        return userMapper.delete(uid);
    }
}
