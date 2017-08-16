package com.realdolmen.candyshop.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;

@ActivateTimer
@Interceptor
public class MethodTimerInterceptor
{
    @Inject private Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception
    {
        long start = System.nanoTime();
        try
        {
            return ic.proceed();
        }
        finally
        {
            long end = System.nanoTime();
            logger.info(ic.getMethod().getName() + " took " + (end - start) / 1_000_000.0 + "ms");
        }
    }
}
