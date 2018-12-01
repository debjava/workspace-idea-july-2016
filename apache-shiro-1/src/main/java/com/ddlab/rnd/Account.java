package com.ddlab.rnd;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by PIKU on 8/19/2016.
 */
@Aspect
public class Account {

    @RequiresRoles("admin")
    public void createAccount(String name) {
//        Subject currentUser =
//                SecurityUtils.getSubject();
//        if(currentUser.isPermitted("admin")) {
//            System.out.println("User is permitted to create an account");
//        }
//        else {
//            System.out.println("user is not permitted ...");
//        }
        System.out.println("Account is created ...");
    }
}
