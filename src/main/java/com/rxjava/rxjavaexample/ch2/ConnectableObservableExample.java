package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ConnectableObservableExample {
    public static void main(String[] args) throws InterruptedException {
        marbleDiagram();
    }

    private static void marbleDiagram() throws InterruptedException {
        String[] dt = {"1", "3", "5"};
        Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> dt[i])
                .take(dt.length);
        ConnectableObservable<String> source = balls.publish();
        source.subscribe(data -> log.info("Subscriber #1 => {}", data));
        source.subscribe(data -> log.info("Subscriber #2 => {}", data));
        source.connect();

        Thread.sleep(250L);
        source.subscribe(data -> log.info("Subscriber #3 => {}", data));
        Thread.sleep(250L);
    }
}
