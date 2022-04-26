package streams.world;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConcatinateEx {
	
	public static void main(String[] args) {
		 List<Integer> list1 = Arrays.asList(1, 2, 3);
	        List<Integer> list2 = Arrays.asList(3, 5, 6);

	        /*
	         * It creates a lazily concatenated stream including all the
	         * elements of first stream and followed by next stream.
	         */
	        Stream<Integer> concatenatedStream = Stream.concat(list1.parallelStream(), list2.parallelStream());
	        concatenatedStream.forEach(s -> System.out.print(s + " "));
	}

}
