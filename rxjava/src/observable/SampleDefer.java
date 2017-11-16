package observable;

import io.reactivex.Observable;

/**
 * Created by hyungsoklee on 2017. 11. 16..
 */
public class SampleDefer {

    public static void main(String[] args) {
        Observable observable = Observable.create(observer -> {
            System.out.println("++ create()");
            observer.onNext("SampleDefer Test");
            observer.onComplete();
        });
        observable.subscribe(System.out::println);

        // defer 는 실행시키는 Observable을 subscribe 할 때 생성하는 오퍼레이터
        observable = Observable.defer(() ->
                observer -> {
                    System.out.println("++ defer()");
                    observer.onNext("SampleDefer Test");
                    observer.onComplete();
                });

        // 이 순간 defer 에서 새로운 Observable을 만들 수 있다
        observable.subscribe(System.out::println);
    }
}
