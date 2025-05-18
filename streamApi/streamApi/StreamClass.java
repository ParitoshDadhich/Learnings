package streamApi;
import java.util.*;
import java.util.function.Consumer;

public class StreamClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.stream().forEach((t) -> System.out.println(t));
		
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		// without stream
		map.forEach((key, value)->System.out.println(key + ": " + value));
		// with stream
		map.entrySet().stream().forEach(obj->System.out.println(obj));
		
		
		// FOR EACH INTERNAL IMPLEMENTATION
		
		Consumer<String> consumer = (t) -> System.out.println(t);
		for(String s: list) {
			consumer.accept(s);
		}
		
	}

}
