import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 생산자는 미친듯이 element 를 생산해 내는데 소비자가 처리하는 속도가 이를 따라가지 못한다면
 * 1. busy waiting
 * 2. out of memory exception 이 발생
 */
public class Backpressure {
    private static final String TEMP_STRING = Arrays.stream(new String[10_000_000]).map(x -> "*").collect(Collectors.joining());

    public static void main(String... args) {
        try {
//            testObservable();
            testFlowable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testObservable() throws InterruptedException {
        Observable.range(0, 1000_000_000)
                .map(x -> {
                    System.out.println("[very fast sender] i'm fast. very fast.");
                    System.out.println(String.format("sending id: %s %d%50.50s", Thread.currentThread().getName(), x, TEMP_STRING));
                    return x + TEMP_STRING;
                })
                .observeOn(Schedulers.computation())
                .subscribe(x -> {
                    Thread.sleep(1000);
                    System.out.println("[very busy receiver] i'm busy. very busy.");
                    System.out.println(String.format("receiving id: %s %50.50s", Thread.currentThread().getName(), x));
                });

        while (true) {
            Thread.sleep(1000);
        }
    }

    private static void testFlowable() throws InterruptedException {
        // Flowable 을 사용하면 default buffer size(128) 이상 backpressure buffer 에 element 가 쌓일 경우 흐름제어
        Flowable.range(0, 1000_000_000)
                .map(x -> {
                    System.out.println("[very fast sender] i'm fast. very fast.");
                    System.out.println(String.format("sending id: %s %d%50.50s", Thread.currentThread().getName(), x, TEMP_STRING));
                    return x + TEMP_STRING;
                })
                .observeOn(Schedulers.computation())
                .subscribe(x -> {
                    Thread.sleep(1000);
                    System.out.println("[very busy receiver] i'm busy. very busy.");
                    System.out.println(String.format("receiving id: %s %50.50s", Thread.currentThread().getName(), x));
                });
        while (true) {
            Thread.sleep(1000);
        }

    }
}
