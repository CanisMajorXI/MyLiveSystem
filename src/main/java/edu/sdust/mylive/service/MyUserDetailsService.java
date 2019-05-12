package edu.sdust.mylive.service;

import edu.sdust.mylive.model.RoleName;
import edu.sdust.mylive.model.UserLoginInfo;
//import edu.sdust.zqw.demo2.model.RoleName;
//import edu.sdust.zqw.demo2.model.UserLoginInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private UserRoleService userRoleService = null;
    @Resource
    private UserLoginInfoService userLoginInfoService  = null;
//    @Resource
//    private  = null;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //System.out.println("thissssssss");
        UserLoginInfo userLoginInfo =  userLoginInfoService.selectByPrimaryKey(email);
       // System.out.println("dasdsadsdadad"+userLoginInfo.getPassword());
        List<RoleName> roleNameList = userRoleService.selectRoleNamesByEmail(email);
      //  int i = 1;
        return changeToUserDetails(userLoginInfo,roleNameList);
    }


    private UserDetails changeToUserDetails(UserLoginInfo userLoginInfo, List<RoleName> roleNameList) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (RoleName role : roleNameList) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
            authorityList.add(authority);
        }
        UserDetails userDetails = new User(userLoginInfo.getEmail(), userLoginInfo.getPassword(), authorityList);
        return userDetails;

    }
}

