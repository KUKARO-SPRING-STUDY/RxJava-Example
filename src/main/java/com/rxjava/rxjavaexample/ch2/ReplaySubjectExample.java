package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.subjects.ReplaySubject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReplaySubjectExample {
    public static void main(String[] args) {
        marbleDiagram();
    }

    private static void marbleDiagram() {
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> log.info("Subscriber #1 => {}", data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> log.info("Subscriber #2 => {}", data));
        subject.onNext("5");
        subject.onComplete();
    }
}
