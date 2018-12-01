package com.ddlab.rnd;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by PIKU on 8/19/2016.
 */
public class Test1 {

    public static void main(String[] args) {
        Account act = new Account();
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();
        System.out.println("Current User :::"+currentUser.getPrincipal());

        if( ! currentUser.isAuthenticated() ) {
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                //log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                //log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                //log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        //"Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
                ae.printStackTrace();
            }
        }
        currentUser = SecurityUtils.getSubject();
        System.out.println("Current User :::"+currentUser.getPrincipal());
        Session session = currentUser.getSession();




        act.createAccount("asdf");
    }
}
