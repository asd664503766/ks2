package cn.dao;

import cn.entity.Role;
import cn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int delete(Integer uid);
    List<User> getAll();
    List<User> getUserName(@Param("username") String username,@Param("enabled") Integer enabled);
    User getUser(String username);
    List<Role> getRole(Integer id);
}
