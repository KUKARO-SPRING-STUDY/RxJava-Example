package com.rxjava.rxjavaexample.ch3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlatMapExample {
    public static void main(String[] args) {
        marbleDiagram();
    }

    public static void marbleDiagram() {
        System.out.println("####################");
        System.out.println("FlatMapExample.marbleDiagram");
        Function<String, Observable<String>> getDoubleDiamonds =
                ball -> Observable.just(ball + "◇", ball + "◇");

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .flatMap(getDoubleDiamonds);
        source.subscribe(log::info);
    }
}
