package observable;

import io.reactivex.Observable;

/**
 * Created by hyungsoklee on 2017. 11. 16..
 */
public class SampleGroupby {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .groupBy(n -> n % 2 == 0)
                .map(i -> i.getKey())
                .subscribe(System.out::println);


        // 배열에서 고유한 값만 가져오고 있을 때
        Integer[] array = {1, 1, 1, 2, 3, 4, 5, 6, 6, 4, 34, 3, 2, 1};
        Observable.fromArray(array)
                .groupBy(i -> i)
                .map(g -> g.getKey())
                .subscribe(System.out::println);

    }
}
