package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObservableNotifications {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("RED", "GREEN", "YELLOW");
        Consumer<String> onNext = ObservableNotifications::onNext;
        Consumer<Throwable> onError = new Consumer<>() {
            @Override
            public void accept(Throwable throwable) {
                log.error("onError() : err : {}", throwable.getMessage());
            }
        };
        Action onComplete = () -> log.info("onComplete");

        Disposable d = source.subscribe(onNext, onError, onComplete);

        log.info("isDisposed() : {}", d.isDisposed());
    }

    public static void onNext(String s) {
        log.info("onNext() : value : {}", s);
    }
}
