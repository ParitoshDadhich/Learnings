package streamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class FilterClassInStream {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.stream().forEach((t) -> System.out.println(t));
		
		Predicate<String> pri = (t) -> {
			if(t.startsWith("C"))
				return true;
			return false;
		};
		
		list.stream().filter(pri).forEach(t->System.out.println(t));
		
		// OR
		
		list.stream().filter(t-> t.startsWith("A")).forEach(t->System.out.println(t));
		
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		// without stream
//		map.forEach((key, value)->System.out.println(key + ": " + value));
//		// with stream
//		map.entrySet().stream().forEach(obj->System.out.println(obj));
		
		map.entrySet().stream().filter(k->k.getKey()%2==0).forEach(obj->System.out.println(obj));
		
		// OR
		
		map.forEach((key, value)->{
			if(key%2 == 0)
				System.out.println(key + ": " + value);
		});
		
	}

}
