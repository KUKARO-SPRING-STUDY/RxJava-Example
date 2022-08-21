package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class ObservableFromFuture {
    public static void main(String[] args) {
        Future<String> future = Executors.newSingleThreadExecutor().submit(()->{
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                return "Hello Future";
            }
        });
        var source = Observable.fromFuture(future);
        source.subscribe(log::info);
    }
}
