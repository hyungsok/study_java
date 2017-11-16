package observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by hyungsoklee on 2017. 11. 16..
 */
public class Sample1 {
    public static void main(String[] args) {
        Observable.just("one object")
                .subscribe(sObserver);

        Observable.just("1", "2", "3")
                .subscribe(sObserver);

        String[] arrays = {"a", "b", "c"};
        Observable.fromArray(arrays)
                .subscribe(sObserver);
        // 람다 표현식
//              .subscribe(
//                        value -> System.out.println("++ onNext() : " + value)
//                        , throwable -> throwable.printStackTrace()
//                        , () -> System.out.println("++ onComplete()"));
    }

    private static Observer<String> sObserver = new Observer<String>() {
        @Override
        public void onSubscribe(@NonNull Disposable disposable) {
            System.out.println("++ onSubscribe() : " + disposable);
            System.out.println("\t>> isDisposed : " + disposable.isDisposed());
        }

        @Override
        public void onNext(@NonNull String s) {
            System.out.println("++ onNext() : " + s);
        }

        @Override
        public void onError(@NonNull Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println("++ onComplete()");
        }
    };

}
