package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObservableCreateExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(emitter -> {
            emitter.onNext(100);
            emitter.onNext(200);
            emitter.onNext(300);
            emitter.onComplete();
        });
        source
                .map(Object::toString)
                .subscribe(log::info);
    }
}
