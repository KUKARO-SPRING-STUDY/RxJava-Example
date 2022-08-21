package com.rxjava.rxjavaexample.ch2;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class ObservableFromArray {
    public static void main(String[] args) {
        var arr = Arrays.asList(100, 200, 300);
        Observable.fromArray(arr)
                .map(Object::toString).subscribe(log::info);
        Observable.fromIterable(arr)
                .map(Object::toString).subscribe(log::info);

        int[] intArray = {400, 500, 600};
        Observable.fromArray(intArray)
                .map(Object::toString).subscribe(log::info);
        Observable.fromArray(Arrays.stream(intArray).boxed().collect(Collectors.toList()))
                .map(Object::toString).subscribe(log::info);
    }
}
