import java.util.List;
import java.util.Vector;

public class Test3 {

	public static void main(String[] args) {


		List<Integer> numbers = new Vector<>();

		numbers.add(123);
		numbers.add(456);
		numbers.add(789);

		numbers.forEach(System.out::println);
	}
}