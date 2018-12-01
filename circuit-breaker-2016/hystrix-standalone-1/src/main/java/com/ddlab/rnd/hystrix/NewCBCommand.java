package com.ddlab.rnd.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Created by PIKU on 8/6/2016.
 */

public class NewCBCommand {

    @HystrixCommand(groupKey="UserGroup", commandKey = "GetUserByIdCommand", fallbackMethod = "fails")
    public String hello() {
        throw new RuntimeException("");
    }

    @HystrixCommand
    public String fails() {

        return "success";
    }
}
