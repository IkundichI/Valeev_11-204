package ru.itis.aspect;

import lombok.Getter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.itis.annotation.MyCache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CacheAspect {

    private final Map<String, CacheObject> cache = new HashMap<>();

    @Around("@annotation(myCacheAnnotation)")
    public Object cacheMethod(ProceedingJoinPoint joinPoint, MyCache myCacheAnnotation) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().toLongString();
        StringBuilder cacheKeyBuilder = new StringBuilder(methodName);
        for (Object arg : args) {
            cacheKeyBuilder.append("_").append(arg.toString());
        }
        String cacheKey = cacheKeyBuilder.toString();

        int duration = myCacheAnnotation.duration();
        Object result = null;
        
        if (cache.containsKey(cacheKey)) {
            CacheObject cachedObject = cache.get(cacheKey);
            if (LocalDateTime.now().isBefore(cachedObject.getExpirationTime())) {
                result = cachedObject.getResult();
            }
        }

        if (result == null) {
            result = joinPoint.proceed();
            cache.put(cacheKey, new CacheObject(result, duration));
        }
        return result;
    }


    @Getter
    private static class CacheObject {
        private final Object result;
        private final LocalDateTime expirationTime;

        CacheObject(Object result, int duration) {
            this.result = result;
            this.expirationTime = LocalDateTime.now().plusSeconds(duration);
        }
    }
}
