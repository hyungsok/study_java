package observable;

import io.reactivex.Observable;

/**
 * Created by hyungsoklee on 2017. 11. 16..
 */
public class SampleMap {

    public static void main(String[] args) {
        Observable.fromArray(new String[]{"개미", "매", "마루"})
                .map(text -> text + " 사랑합니다.")
                .subscribe(
                        text -> System.out.println("++ onNext : " + text),
                        e -> System.out.println("++ onError"),
                        () -> System.out.println("++ onCompleted"));
    }
}
