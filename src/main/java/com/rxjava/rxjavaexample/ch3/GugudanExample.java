package com.rxjava.rxjavaexample.ch3;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class GugudanExample {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        reactiveV1();
    }

    public static void reactiveV1() {
        System.out.println("####################");
        System.out.println("GugudanExample.reactiveV1");
        System.out.print("Gugudan Input : ");
        int dan = scanner.nextInt();

        Observable<Integer> source = Observable.range(1, 9);
        source.subscribe(row -> print(dan, row));
    }

    public static void print(int dan, int row) {
        log.info("{} * {} = {}", dan, row, dan * row);
    }
}
