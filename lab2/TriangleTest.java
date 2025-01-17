package lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;


public class TriangleTest {
	@Rule				
	public ErrorCollector collector= new ErrorCollector();
	private enum Triangles {
		SCALENE,
		EQUILATERAL,
		ISOSCELES,
		RIGHT_ANGLED,
		IMPOSSIBLE
	}
	
	
	private boolean isClass(Triangle triangle, Triangles c) throws Error {
		if(c == Triangles.SCALENE) {
			return triangle.isScalene();
		} else if(c == Triangles.EQUILATERAL) {
			return triangle.isEquilateral();
		} else if(c == Triangles.ISOSCELES) {
			return triangle.isIsosceles();
		} else if(c == Triangles.RIGHT_ANGLED) {
			return triangle.isRightAngled();
		} else if(c == Triangles.IMPOSSIBLE) {
			return triangle.isImpossible();
		} else {
			throw new Error("Weird triangleclass, what happened?");
		}
	}
	
	private void testTriangleIs(Triangle triangle, String description, String expectedClass, Triangles[] classesShouldBe, Triangles[] classesShouldNotBe) {
		try {			
	        assertEquals(description + "\nError in classify():", expectedClass, triangle.classify());				
	    } catch (Throwable t) {					
	        collector.addError(t);					
	    }
		for (Triangles c : classesShouldBe) {
			try {			
				assertTrue(description + "\nShould be " + c.toString() +  " but was not classified as that.", isClass(triangle, c));
		    } catch (Throwable t) {					
		        collector.addError(t);					
		    }
		}
		for (Triangles c : classesShouldNotBe) {
			try {			
				assertFalse(description + "\nShould not be " + c.toString() + " but was classified as that.", isClass(triangle, c));
		    } catch (Throwable t) {					
		        collector.addError(t);					
		    }
		}
	}
	
	
	private void testTriangle(int[] sides, String description, String expectedClass, Triangles[] shouldBe, Triangles[] shouldNotBe) {
		Triangle testTriangle = new Triangle(sides[0], sides[1], sides[2]);
		testTriangleIs(testTriangle, description, expectedClass, shouldBe, shouldNotBe);
	}
	
	
	@Test
	public void testAllTrianges() {
		testTriangle(new int[]{1,1,1},
				"Equilateral and Isosceles", "equilateral",
				new Triangles[]{Triangles.ISOSCELES, Triangles.EQUILATERAL},
				new Triangles[]{Triangles.SCALENE, Triangles.RIGHT_ANGLED, Triangles.IMPOSSIBLE});
		
		testTriangle(new int[]{2,3,4},
				"Normal scalene", "scalene",
				new Triangles[]{Triangles.SCALENE},
				new Triangles[]{Triangles.EQUILATERAL, Triangles.ISOSCELES, Triangles.RIGHT_ANGLED, Triangles.IMPOSSIBLE});
		
		testTriangle(new int[]{2,2,3},
				"Normal isosceles", "isosceles",
				new Triangles[]{Triangles.ISOSCELES},
				new Triangles[]{Triangles.EQUILATERAL, Triangles.SCALENE, Triangles.RIGHT_ANGLED, Triangles.IMPOSSIBLE});
		
		testTriangle(new int[]{3,4,5},
				"Normal right angled", "right-angled",
				new Triangles[]{Triangles.RIGHT_ANGLED},
				new Triangles[]{Triangles.EQUILATERAL, Triangles.SCALENE, Triangles.ISOSCELES, Triangles.IMPOSSIBLE});
		
		testTriangle(new int[]{1,1,2},
				"Small impossible not-triangle, sides not adding up", "impossible",
				new Triangles[]{Triangles.IMPOSSIBLE},
				new Triangles[]{Triangles.EQUILATERAL, Triangles.SCALENE, Triangles.ISOSCELES, Triangles.RIGHT_ANGLED});

		testTriangle(new int[]{-1,10,10},
				"Negative side, should this actually throw an error?", "impossible",
				new Triangles[]{Triangles.IMPOSSIBLE},
				new Triangles[]{Triangles.EQUILATERAL, Triangles.SCALENE, Triangles.ISOSCELES, Triangles.RIGHT_ANGLED});
		
		testTriangle(new int[]{0,1,1},
				"Zero-side, should this actually throw an error?", "impossible",
				new Triangles[]{Triangles.IMPOSSIBLE},
				new Triangles[]{Triangles.EQUILATERAL, Triangles.SCALENE, Triangles.ISOSCELES, Triangles.RIGHT_ANGLED});
		
	}

}
