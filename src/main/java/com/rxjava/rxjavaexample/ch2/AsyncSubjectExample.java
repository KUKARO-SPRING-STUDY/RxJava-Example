package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsyncSubjectExample {
    public static void main(String[] args) {
        marbleDiagram();
        asSubscriber();
        afterComplete();
    }

    //Observable에서 발행한 마지막 데이터를 얻어올 수 이쓴 Subject 클래스입니다.
    private static void marbleDiagram() {
        System.out.println("AsyncSubjectExample.marbleDiagram");
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> log.info("Subscriber #1 => {}", data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> log.info("Subscriber #2 => {}", data));
        subject.onNext("5");
        subject.onComplete();
    }

    private static void asSubscriber() {
        System.out.println("AsyncSubjectExample.asSubscriber");
        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperature);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> log.info("Subscriber #1 => {}", data));
        source.subscribe(subject);
    }

    private static void afterComplete() {
        System.out.println("AsyncSubjectExample.afterComplete");
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(10);
        subject.onNext(11);
        subject.subscribe(data -> log.info("Subscriber #1 => {}", data));
        subject.onNext(12);
        subject.onComplete();
        subject.onNext(13);
        subject.subscribe(data -> log.info("Subscriber #2 => {}", data));
        subject.subscribe(data -> log.info("Subscriber #3 => {}", data));
    }
}
