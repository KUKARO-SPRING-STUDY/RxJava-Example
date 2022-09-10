package com.rxjava.rxjavaexample.ch3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class GugudanExample {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        reactiveV1();
//        reactiveV2();
//        reactiveV3();
        usingResultSelector();
    }

    public static void reactiveV1() {
        System.out.println("####################");
        System.out.println("GugudanExample.reactiveV1");
        System.out.print("Gugudan Input : ");
        int dan = scanner.nextInt();

        Observable<Integer> source = Observable.range(1, 9);
        source.subscribe(row -> print(dan, row));
    }

    public static void reactiveV2() {
        System.out.println("####################");
        System.out.println("GugudanExample.reactiveV2");
        System.out.print("Gugudan Input : ");
        int dan = scanner.nextInt();

        Function<Integer, Observable<String>> gugudan = num -> Observable.range(1, 9)
                .map(row -> printFormat(dan, row));
        Observable<String> source = Observable.just(dan).flatMap(gugudan);
        source.subscribe(log::info);
    }

    public static void reactiveV3() {
        System.out.println("####################");
        System.out.println("GugudanExample.reactiveV3");
        System.out.print("Gugudan Input : ");
        int dan = scanner.nextInt();

        Observable<String> source = Observable.just(dan)
                .flatMap(num -> Observable.range(1, 9)
                        .map(row -> String.format("%d * %d = %d", num, row, num * row)));
        source.subscribe(log::info);
    }

    public static void usingResultSelector() {
        System.out.println("####################");
        System.out.println("GugudanExample.usingResultSelector");
        System.out.print("Gugudan Input : ");
        int dan = scanner.nextInt();

        Observable<String> source = Observable.just(dan)
                .flatMap(num -> Observable.range(1, 9),
                        (num, row) -> String.format("%d * %d = %d", num, row, num * row));
        source.subscribe(log::info);
    }

    public static void print(int dan, int row) {
        log.info("{} * {} = {}", dan, row, dan * row);
    }

    public static String printFormat(int dan, int row) {
        return String.format("%d * %d = %d", dan, row, dan * row);
    }
}
