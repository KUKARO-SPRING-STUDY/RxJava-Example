package com.rxjava.rxjavaexample.ch1;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class FirstExample {
    public void emit(){
        Observable.just("Hello", "RxJava 3!!")
                .subscribe(log::info);
    }

    public static void main(String[] args) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }
}
