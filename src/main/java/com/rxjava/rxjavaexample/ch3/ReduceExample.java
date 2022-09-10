package com.rxjava.rxjavaexample.ch3;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReduceExample {
    public static void main(String[] args) {
        marbleDiagram();
    }

    public static void marbleDiagram() {
        String[] balls = {"1", "3", "5"};
        Maybe<String> source = Observable.fromArray(balls)
                .reduce((ball1, ball2) -> String.format("%s(%s))", ball2, ball1));
        source.subscribe(log::info);
    }
}
