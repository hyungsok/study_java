package dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyungsoklee on 2017. 11. 16..
 */
public class Restaurant {
    public String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public static List<Restaurant> getList() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("카페413프로젝트"));
        restaurants.add(new Restaurant("대우식당"));
        restaurants.add(new Restaurant("지아니스 나폴리"));
        restaurants.add(new Restaurant("고갯마루집"));
        restaurants.add(new Restaurant("크리에잇쿠키"));
        restaurants.add(new Restaurant("오무리안"));
        restaurants.add(new Restaurant("봉된장"));
        restaurants.add(new Restaurant("육전식당"));
        return restaurants;
    }
}
