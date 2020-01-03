package utils;

import play.mvc.Result;

import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class AtomicCounter {
    private AtomicInteger counter=new AtomicInteger();
    private AtomicLong counter1=new AtomicLong();
    public Integer getCount() {
        return counter.getAndIncrement();
    }
}
