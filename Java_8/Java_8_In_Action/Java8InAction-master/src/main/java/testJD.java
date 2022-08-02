import java.util.Arrays;
import java.util.List;

public class testJD {
   public static void main(String[] args) {
	List<Integer> mylist  =  Arrays.asList(1,3,5,7,8,8);
	mylist.stream().sorted().forEach(System.out::println);
}
}
