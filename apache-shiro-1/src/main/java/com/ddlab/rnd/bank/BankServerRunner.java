/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.ddlab.rnd.bank;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class BankServerRunner {

    private SecureBankService _bankService;

    public synchronized void start() throws Exception {
        if (_bankService == null) {
            _bankService = new SecureBankService();
            _bankService.start();
            _bankService.createNewAccount("dan");
            _bankService.closeAccount(1L);
        }
    }

    public synchronized void stop() {
        if (_bankService != null) {
            try {
                _bankService.dispose();
            } finally {
                _bankService = null;
            }
        }
    }

    public BankService getBankService() {
        return _bankService;
    }

    public static void main(String[] args) {
        try {
            IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiroBankServiceTest.ini");
            SecurityManager securityManager = factory.getInstance();
            SecurityUtils.setSecurityManager(securityManager);

            Subject currentUser = SecurityUtils.getSubject();
            System.out.println("Current User :::"+currentUser.getPrincipal());

            if( ! currentUser.isAuthenticated() ) {
                UsernamePasswordToken token = new UsernamePasswordToken("dan", "123");
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


            BankServerRunner server = new BankServerRunner();
//            server.start();


            server._bankService = new SecureBankService();
//            _bankService.start();
            server._bankService.createNewAccount("dan");
            server._bankService.closeAccount(1L);


//            server._bankService.closeAccount(1L);


            server.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
