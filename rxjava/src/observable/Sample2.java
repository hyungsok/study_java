package observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by hyungsoklee on 2017. 11. 16..
 */
public class Sample2 {
    public static void main(String[] args) {
        Observable.create(
                subscriber -> {
                    for (int i = 0; i < 50; i++) {
                        subscriber.onNext("value_" + i);
                    }
                    subscriber.onComplete();
                })
                .subscribe(
                        new Observer<Object>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable disposable) {
                                System.out.println("++ onSubscribe() : " + disposable);
                                System.out.println("\t>> isDisposed : " + disposable.isDisposed());
                            }

                            @Override
                            public void onNext(@NonNull Object value) {
                                System.out.println("++ onNext() : " + value);
                            }

                            @Override
                            public void onError(@NonNull Throwable throwable) {
                                throwable.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                System.out.println("++ onComplete()");
                            }
                        });
    }
}
