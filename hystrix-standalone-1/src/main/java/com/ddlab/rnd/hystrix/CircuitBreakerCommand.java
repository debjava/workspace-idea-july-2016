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
//        delay(500);
//        System.out.println("Circuit open? > " + this.isCircuitBreakerOpen());
//        System.out.println("Message----->"+message);
        int val = Integer.parseInt(message);
        int k = val%2;
//        System.out.println("K-------->"+k);
        if( k == 0 )
            throw new RuntimeException("Failed!");
        else
            return "Hi";
    }

    private void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getFallback() {
        return "Hello Fallback";
    }


}