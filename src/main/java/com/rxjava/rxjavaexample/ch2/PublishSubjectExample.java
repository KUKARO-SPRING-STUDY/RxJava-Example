package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PublishSubjectExample {
    public static void main(String[] args) {
        marbleDiagram();
    }

    private static void marbleDiagram() {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> log.info("Subscriber #1 => {}", data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> log.info("Subscriber #2 => {}", data));
        subject.onNext("5");
        subject.onComplete();
    }
}
