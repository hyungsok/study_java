import io.reactivex.Observable;

/**
 * Created by hyungsoklee on 2017. 11. 15..
 */
public class Nulls {
    /**
     * RxJava 2.x no longer accepts null values and the following will yield NullPointerException
     * immediately or as a signal to downstream:
     */

    private static enum Exception {
        NullPointException;
    }

    public static void main(String[] args) {
        /**
         * Exception in thread "main" java.lang.NullPointerException: The item is null
         at io.reactivex.internal.functions.ObjectHelper.requireNonNull(ObjectHelper.java:39)
         at io.reactivex.Observable.just(Observable.java:2168)
         at Nulls.main(Nulls.java:14)
         at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
         at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         at java.lang.reflect.Method.invoke(Method.java:498)
         at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
         */
//        Observable.just(null)
//                .subscribe(System.out::println, Throwable::printStackTrace);


        Observable.just(Exception.NullPointException)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
