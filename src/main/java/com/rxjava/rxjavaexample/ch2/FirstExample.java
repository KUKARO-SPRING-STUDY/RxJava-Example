package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FirstExample {
    public void emit() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .map(Object::toString)
                .subscribe(log::info);
    }

    public static void main(String[] args) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }
}
