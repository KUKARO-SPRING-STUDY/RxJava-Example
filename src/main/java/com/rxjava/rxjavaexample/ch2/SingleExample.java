package com.rxjava.rxjavaexample.ch2;

import com.rxjava.rxjavaexample.common.Order;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleExample {
    public static void main(String[] args) {
        Single<String> source = Single.just("Hello Single");
        source.subscribe(var -> log.info(var));

        // 1. 기존 Observable에서 Single 객체로 변환하기
        Observable<String> sourceObservable = Observable.just("Hello Single from Observable");
        Single.fromObservable(sourceObservable)
                .subscribe(var -> log.info(var));

        // 2. single() 함수를 호출해 Single 객체 생성하기
        Observable.just("Hello Single method")
                .single("default item")
                .subscribe(var -> log.info(var));

        // 3. first() 함수를 호출해서 Single 객체 생성하기
        String[] colors = {"Red", "Blue", "Gold"};
        Observable.fromArray(colors)
                .first("default item")
                .subscribe(var -> log.info(var));

        // 4. emptuy Observable에서 Single 객체 생성하기.
        Observable.<String>empty()
                .single("default value")
                .subscribe(var -> log.info(var));

        // 5. take() 함수에서 Single 객체 생성하기
        Observable.just(new Order("ORD-1"), new Order("ORD-2"))
                .take(1)
                .single(new Order("default order"))
                .subscribe(var -> log.info(var.toString()));

        // 멤버를 두개 이상 넣으면 에러가 난다
        Single<String> sourceString = Observable.just("Hello Single","Error")
                .single("default item");
        sourceString.subscribe(var->log.info(var));
    }
}
