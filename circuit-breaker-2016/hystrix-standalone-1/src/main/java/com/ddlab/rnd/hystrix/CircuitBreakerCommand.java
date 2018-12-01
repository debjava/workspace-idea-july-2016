package com.ddlab.rnd.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class CircuitBreakerCommand extends HystrixCommand<String> {

    private final String message;

    public CircuitBreakerCommand(String message) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withCircuitBreakerEnabled(true)
//                                .withCircuitBreakerRequestVolumeThreshold(0)
//                                .withCircuitBreakerErrorThresholdPercentage(1)
                ));

        this.message = message;
    }

    @Override
    protected String run() {
        int val = Integer.parseInt(message);
        int k = val%2;
        if( k == 0 )
            throw new RuntimeException("Failed!");
        else
            return "Hi";
    }

    @Override
    protected String getFallback() {
        return "Hello Fallback";
    }

}