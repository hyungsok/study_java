import io.reactivex.*;

/**
 * Created by hyungsoklee on 2017. 11. 15..
 */
public class HelloWorld {
    public static void main(String[] args) {
        // 0..N flows, supporting Reactive-Streams and backpressure
        Flowable.just("Flowable - HelloWorld").subscribe(System.out::println);
        // 0..N flows, no backpressure
        Observable.just("Observale - HelloWorld").subscribe(System.out::println);
        /**
         * Single 은 Observable 과는 다르게 onSuccess(item) 과 onError(throwable)만을 가진다.
         * 비동기 처리 후 결과만을 반환해야 하는 경우, 즉 위와 같이 dao 등을 통해 데이터를 비동기로 불러오고자 하는 경우에 적절하다.
         */
        Single.just("Single - HelloWorld").subscribe(System.out::println);
        /**
         * Completable 은 onCompleted() 와 onError(throwable) 만을 가진다.
         * 비동기 처리 후 반환되는 결과가 없는 경우 사용하면 된다.
         */
        Completable.fromObservable(Observable.just("Completable - Hello world"))
                .subscribe(
                        () -> System.out.println("Completable onComplete()")
                        , throwable -> System.out.println("Completable onError()"));
        /**
         * Maybe 는 onSuccess(item) onComplete() 중 하나가 전파되는 작업흐름이다. (물론 예외가 발생한다면 onError(throwable) 가 전파될 수 있다.)
         * RxJava 2.0 에서는 null 을 전파할 수 없다.
         * Maybe 를 사용한다면 Optional 을 사용하지 않고도 0 또는 1 개의 item 을 전파하는 작업흐름을 만들 수 있다.
         */
        Maybe.just("Maybe - HelloWorld").subscribe(System.out::println);
    }
}
