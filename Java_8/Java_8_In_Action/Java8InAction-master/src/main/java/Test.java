import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
 public static void main(String[] args) {
	
	 String str = "Jitendrajte";
	         String[] split = str.split("");
      
	  // Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(
	          LinkedHashMap<String, Long> collect = Arrays.stream(split)
	        		 .collect(Collectors.groupingBy(
	        				 Function.identity(),LinkedHashMap::new,Collectors.counting()));
	          System.out.println(collect);
 }
}
