package com.rxjava.rxjavaexample.ch3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MapExample {
    public static void main(String[] args) {
        marbleDiagram();
        mappingType();
    }

    public static void marbleDiagram() {
        System.out.println("####################");
        System.out.println("MapExample.marbleDiagram");
        String[] balls = {"1", "2", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .map(ball -> ball + "◇");
        source.subscribe(log::info);
    }

    public static void mappingType() {
        System.out.println("####################");
        System.out.println("MapExample.mappingType");
        Function<String, Integer> ballToIndex = ball -> {
            switch (ball) {
                case "RED":
                    return 1;
                case "YELLOW":
                    return 2;
                case "GREEN":
                    return 3;
                case "BLUE":
                    return 5;
                default:
                    return -1;
            }
        };
        String[] balls = {"RED", "YELLOW", "GREEN", "BLUE"};
        Observable<String> source = Observable.fromArray(balls)
                .map(ballToIndex)
                .map(Object::toString);
        source.subscribe(log::info);
    }
}
