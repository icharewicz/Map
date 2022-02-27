package generic_types;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericMainApp {

    public static void main(String[] args) {


//        List<String> letters = Arrays.asList("Ala", "Ola", "Zuza","Marta");
//        System.out.println(streamList(letters));
//        System.out.println(streamList2(letters));

        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 18);
        map.put("Python", 1);
        map.put("C#", 12);
        map.put("PHP", 0);

        mapList(map);
        //mapList2(map);

    }

    public static void mapList (Map<String , Integer> map){
        for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
             iterator.hasNext();){
            Map.Entry<String, Integer> entry = iterator.next();
            String delimiter = iterator.hasNext() ? "," : ".";
            System.out.println("Klucz: " + entry.getKey() + ", Value: "
                    + entry.getValue() + delimiter);
        }
    }

    public static void mapList2 (Map<String , Integer> map){
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
        for (int i = 0; i < entryList.size(); i++){
            Map.Entry<String, Integer> entry = entryList.get(i);
            String delimiter = i == entryList.size() - 1
                    ? "."
                    : ",";
            System.out.println("Klucz: " + entry.getKey() + ", Value: "
                    + entry.getValue() + delimiter);
        }
    }

    public static List<String> streamList (List<String> list){
        return list.stream().sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
    }

    public static List<String> streamList2 (List<String> list){
        return list.stream().sorted((s1,s2) -> s2.compareToIgnoreCase(s1))
                .collect(Collectors.toList());
    }

//    public static List<String> streamList2 (List<String> list){
//        Collections.sort(list, Comparator.reverseOrder());
//        return list;
//    }

    //Stream<String> stringStream = list.stream();
    public static double getTotalArea(List<? extends IShape> shapes){
        return shapes.stream().mapToDouble(shape -> shape.getArea()).sum();
    }

    private static Pair<String, Double> estimateBmi(int weight, int height){
        double bmi = weight / Math.pow((double) height / 100.0, 2);
        String s = bmi < 24.9 && bmi > 18.5
                ? "BMI optymalne"
                : "BMI nie optymalne";
        return new Pair<>(s, bmi);
    }
}
