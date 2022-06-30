package lambdasinaction.chap8;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lambdasinaction.chap6.ToListCollector;
import lambdasinaction.chap8.Debugging.Point;

public class DebugginTest {
	
	@Test
	public void testMoveAllPointsRightBy() throws Exception{
	List<Point> points =
	Arrays.asList(new Point(5, 5), new Point(10, 5));
	List<Point> expectedPoints =
	Arrays.asList(new Point(15, 5), new Point(20, 5));
	//List<Point> newPoints = points.stream().map(p-> new Point(p.getX() + 10, p.getY())).collect(ToListCollector<Point>());
	//assertEquals(expectedPoints, newPoints);
	}
	
}
