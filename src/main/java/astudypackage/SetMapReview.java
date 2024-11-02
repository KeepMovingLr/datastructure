package astudypackage;

import org.junit.Test;

import java.util.*;

public class SetMapReview {

    @Test
    public void testLinkedHashSet(){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("apple");
        linkedHashSet.add("banana");
        linkedHashSet.add("orange");
        System.out.println(linkedHashSet);

        List<String> list = new ArrayList<>(linkedHashSet);
        Collections.reverse(list);
        System.out.println(list);
    }

    @Test
    public void testLinkedHashMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("apple", "100");
        map.put("banana" , "200");
        map.put("orange" , "300");
        System.out.println(map);

        List<String> list = new ArrayList<>(map.keySet());
        Collections.reverse(list);
        System.out.println(list);
        for (String s : list) {
            System.out.println(map.get(s));
        }
    }
}
