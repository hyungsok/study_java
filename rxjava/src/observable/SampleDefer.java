package observable;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by hyungsoklee on 2017. 11. 16..
 */
public class SampleDefer {

    public static void main(String[] args) {
        Observable observable;

        observable = Observable.create(
                observer -> {
                    System.out.println("\t!! create()");
                    observer.onNext("create Test");
                    observer.onComplete();
                });
        System.out.println(">> create subscribe()");
        observable.subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("\t++ create onSubscribe() : " + disposable);
                System.out.println("\t\t>> isDisposed : " + disposable.isDisposed());
            }

            @Override
            public void onNext(@NonNull Object value) {
                System.out.println("\t++ onNext() : " + value);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("\t++ onComplete()");
            }
        });


        System.out.println("-----------------------------------------------------------------------------------");

        // defer 는 실행시키는 Observable을 subscribe 할 때 생성하는 오퍼레이터
//        observable = Observable.defer(new Callable<ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> call() throws Exception {
//                System.out.println("\t++ defer()!!!!!!!!!");
//                return Observable.just("defer Test");
//            }
//        });
        observable = Observable.defer(() -> {
            System.out.println("\t!! defer()");
            return Observable.just("defer Test");
        });
        // 이 순간 defer 에서 새로운 Observable을 만들 수 있다
        System.out.println(">> defer subscribe()");
        observable.subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("\t++ defer onSubscribe() : " + disposable);
                System.out.println("\t\t>> isDisposed : " + disposable.isDisposed());
            }

            @Override
            public void onNext(@NonNull Object value) {
                System.out.println("\t++ onNext() : " + value);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("\t++ onComplete()");
            }
        });
    }
}
