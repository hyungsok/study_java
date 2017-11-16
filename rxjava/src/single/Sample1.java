package single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by hyungsoklee on 2017. 11. 15..
 */
public class Sample1 {
    public static void main(String[] args) {
        /**
         * Single 은 Observable 과는 다르게 onSuccess(item) 과 onError(throwable)만 있다
         */
        Single.just("Kevin")
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("++ onSubscribe : " + d.isDisposed());
                    }

                    @Override
                    public void onSuccess(String value) {
                        System.out.println("++ onSuccess value : " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("++ onError : " + e.getMessage());
                    }
                });

    }
}
