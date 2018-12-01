package com.ddlab.rnd.cb;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by PIKU on 8/6/2016.
 */
public class FailSafeDownloader extends HystrixCommand<String> {

    private final String message;

    public FailSafeDownloader(String message) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withCircuitBreakerEnabled(true)
//                                .withCircuitBreakerRequestVolumeThreshold(0)
//                                .withCircuitBreakerErrorThresholdPercentage(1)
                                .withExecutionTimeoutInMilliseconds(60000)//60 seconds

//                                .withExecutionIsolationStrategy(HystrixCommandProperties
//                                        .ExecutionIsolationStrategy.SEMAPHORE)


//                                .withExecutionTimeoutEnabled(true)
//                                .withExecutionIsolationThreadInterruptOnTimeout(false)
                ));

        this.message = message;
    }

    @Override
    protected String run() {
        String urlPath = "https://developer.aptimus.com/api/validation-service/1/apti/status";
        String contents = new HttpDownloader().download(urlPath,"application/xml");
        if( !contents.startsWith("<ABCD>")) throw new RuntimeException("Improper Data");
        return contents;
    }

    @Override
    protected String getFallback() {
        return "Hello Fallback";
    }

}
