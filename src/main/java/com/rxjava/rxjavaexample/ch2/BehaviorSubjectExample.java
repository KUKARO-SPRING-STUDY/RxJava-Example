package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BehaviorSubjectExample {
    public static void main(String[] args) {
        marbleDiagram();
    }

    private static void marbleDiagram() {
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("6");
        subject.subscribe(data -> log.info("Subscriber #1 => {}", data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> log.info("Subscriber #2 => {}", data));
        subject.onNext("5");
        subject.onComplete();
    }
}
