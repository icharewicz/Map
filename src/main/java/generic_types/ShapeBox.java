package generic_types;

import java.util.ArrayList;
import java.util.List;

public class ShapeBox <T extends IShape> {

    private List<T> box = new ArrayList<>();

    public void add(T shape) {
        box.add(shape);
    }

    public double getTptalArea(){
        return box.stream().mapToDouble(shape -> shape.getArea())
                .sum();
//        double sum = 0;
//        for (T shape : box) {
//            sum += shape.getArea();
//        }
//        return sum;
    }
}
