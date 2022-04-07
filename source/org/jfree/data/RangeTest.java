package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest {

	private Range rangeObjectUnderTest;
	private Range rangeObjectUnderTest2;
	private Range rangeObjectUnderTest3;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
		rangeObjectUnderTest2 = new Range(-2, 2);
		rangeObjectUnderTest3 = new Range(-3, 3);

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testGetLength() {
		rangeObjectUnderTest = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output.", 0.0, rangeObjectUnderTest.getLength(),DELTA);

		rangeObjectUnderTest = new Range(4, 9);
		assertEquals("getLength: Did not return the expected output.", 5.0, rangeObjectUnderTest.getLength(),DELTA);

		rangeObjectUnderTest = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output.", 0.0, rangeObjectUnderTest.getLength(),DELTA);

		rangeObjectUnderTest = new Range(-11, -4);
		assertEquals("getLength: Did not return the expected output.", 7.0, rangeObjectUnderTest.getLength(),DELTA);

		rangeObjectUnderTest = new Range(-5, 3);
		assertEquals("getLength: Did not return the expected output.", 8.0, rangeObjectUnderTest.getLength(),DELTA);
	}

	// 5 Custom Method Tests

	// 1 //
	// Get Lower Bound

	@Test
	public void testGetLowerBoundBothValuesPositiveAndSame() {
		rangeObjectUnderTest = new Range(10.0, 10.0);
		assertEquals("getLowerBound: Did not return the expected output.", 10.0, rangeObjectUnderTest.getLowerBound(),DELTA);
	}

	@Test
	public void testGetLowerBoundBothValuesNegativeAndSame() {
		rangeObjectUnderTest = new Range(-10.0, -10.0);
		assertEquals("getLowerBound: Did not return the expected output.", -10.0, rangeObjectUnderTest.getLowerBound(),DELTA);
	}

	@Test
	public void testGetLowerBoundBothValuesPositive() {
		rangeObjectUnderTest = new Range(5.0, 10.0);
		assertEquals("getLowerBound: Did not return the expected output.", 5.0, rangeObjectUnderTest.getLowerBound(),DELTA);
	}

	@Test
	public void testGetLowerBoundBothValuesNegative() {
		rangeObjectUnderTest = new Range(-4.0, -1.0);
		assertEquals("getLowerBound: Did not return the expected output.", -4.0, rangeObjectUnderTest.getLowerBound(),DELTA);
	}

	@Test
	public void testGetLowerBoundOneNegativeOnePositive() {
		rangeObjectUnderTest = new Range(-9.0, 14.0);
		assertEquals("getLowerBound: Did not return the expected output.", -9.0, rangeObjectUnderTest.getLowerBound(),DELTA);
	}

	@Test
	public void testGetLowerBoundOneZeroOnePositive() {
		rangeObjectUnderTest = new Range(0.0, 7.0);
		assertEquals("getLowerBound: Did not return the expected output.", 0.0, rangeObjectUnderTest.getLowerBound(),DELTA);
	}

	@Test
	public void testGetLowerBoundOneZeroOneNegative() {
		rangeObjectUnderTest = new Range(-4.0, 0.0);
		assertEquals("getLowerBound: Did not return the expected output.", -4.0, rangeObjectUnderTest.getLowerBound(),DELTA);
	}

	@Test
	public void testGetLowerBoundBothZero() {
		rangeObjectUnderTest = new Range(0.0, 0.0);
		assertEquals("getLowerBound: Did not return the expected output.", 0.0, rangeObjectUnderTest.getLowerBound(),DELTA);
	}

	// 2 //
	// Get Upper Bound

	@Test
	public void testGetUpperBoundBothValuesPositiveAndSame() {
		rangeObjectUnderTest = new Range(10.0, 10.0);
		assertEquals("getUpperBound: Did not return the expected output.", 10.0, rangeObjectUnderTest.getUpperBound(),DELTA);
	}

	@Test
	public void testGetUpperBoundBothValuesNegativeAndSame() {
		rangeObjectUnderTest = new Range(-10.0, -10.0);
		assertEquals("getUpperBound: Did not return the expected output.", -10.0, rangeObjectUnderTest.getUpperBound(),DELTA);
	}

	@Test
	public void testGetUpperBoundBothValuesPositive() {
		rangeObjectUnderTest = new Range(5.0, 10.0);
		assertEquals("getUpperBound: Did not return the expected output.", 10.0, rangeObjectUnderTest.getUpperBound(),DELTA);
	}

	@Test
	public void testGetUpperBoundBothValuesNegative() {
		rangeObjectUnderTest = new Range(-4.0, -1.0);
		assertEquals("getUpperBound: Did not return the expected output.", -1.0, rangeObjectUnderTest.getUpperBound(),DELTA);
	}

	@Test
	public void testGetUpperBoundOneNegativeOnePositive() {
		rangeObjectUnderTest = new Range(-9.0, 14.0);
		assertEquals("getUpperBound: Did not return the expected output.", 14.0, rangeObjectUnderTest.getUpperBound(),DELTA);
	}

	@Test
	public void testGetUpperBoundOneZeroOnePositive() {
		rangeObjectUnderTest = new Range(0.0, 7.0);
		assertEquals("getUpperBound: Did not return the expected output.", 7.0, rangeObjectUnderTest.getUpperBound(),DELTA);
	}

	@Test
	public void testGetUpperBoundOneZeroOneNegative() {
		rangeObjectUnderTest = new Range(-4.0, 0.0);
		assertEquals("getUpperBound: Did not return the expected output.", 0.0, rangeObjectUnderTest.getUpperBound(),DELTA);
	}

	@Test
	public void testGetUpperBoundBothZero() {
		rangeObjectUnderTest = new Range(0.0, 0.0);
		assertEquals("getUpperBound: Did not return the expected output.", 0.0, rangeObjectUnderTest.getUpperBound(),DELTA);
	}

	// 3 //
	// Contains

	@Test
	public void testContainsReturnsFalseJustBelowMinimum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertFalse("contains: Did not return the expected output.", rangeObjectUnderTest.contains(-100.1));
	}

	@Test
	public void testContainsReturnsTrueOnMinimum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(-100));
	}

	@Test
	public void testContainsReturnsTrueJustAboveMinimum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(-99.9));
	}

	@Test
	public void testContainsReturnsTrueNominalValue() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(0));
	}

	@Test
	public void testContainsReturnsTrueJustUnderMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(99.9));
	}

	@Test
	public void testContainsReturnsTrueOnMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(100));
	}

	@Test
	public void testContainsReturnsFalseJustAboveMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertFalse("contains: Did not return the expected output.", rangeObjectUnderTest.contains(100.1));
	}

	// 4 //
	// Intersects

	@Test
	public void testIntersectsReturnsFalseJustBelowMinimum() {
		rangeObjectUnderTest = new Range(-100.0, 100.0);
		assertFalse("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(-200.0, -100.1));
	}

	@Test
	public void testIntersectsReturnsTrueOnMinimum() {
		rangeObjectUnderTest = new Range(-100.0, 100.0);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(-200.0, -100.0));
	}

	@Test
	public void testIntersectsReturnsTrueJustAboveMinimum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(-200, -99.9));
	}

	@Test
	public void testIntersectsReturnsTrueNominalValue() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(-50, 50));
	}

	@Test
	public void testIntersectsReturnsTrueJustBelowMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(99.9, 200));
	}

	@Test
	public void testIntersectsReturnsTrueOnMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(100, 200));
	}

	@Test
	public void testIntersectsReturnsFalseJustAboveMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(100.1, 200));
	}

	@Test
	public void testIntersectsExceptionThrownWhenLowerGreaterThanUppper() {
		try {
			rangeObjectUnderTest = new Range(-100, 100);
			rangeObjectUnderTest.intersects(200, 100);
			fail("No exception thrown-Expected outcome was: a thrown exception");
		} catch (Exception e) {
			return;
		}
	}

	@Test
	public void testIntersectsReturnsTrueWhenLowerEqualToUpper() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(50, 50));
	}

	// 5 //
	// Constrain

	@Test
	public void testConstrainReturnsExpectedJustBelowLower() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("constrain: Did not return the expected output.", -100, rangeObjectUnderTest.constrain(-100.1),DELTA);
	}

	@Test
	public void testConstrainReturnsExpectedOnMinimum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("constrain: Did not return the expected output.", rangeObjectUnderTest.constrain(-100), -100.0,DELTA);
	}

	@Test
	public void testConstrainReturnsExpectedJustAboveMinimum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("constrain: Did not return the expected output.", rangeObjectUnderTest.constrain(-99.9), -99.9,DELTA);
	}

	@Test
	public void testConstrainReturnsExpectedNominalValue() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("constrain: Did not return the expected output.", rangeObjectUnderTest.constrain(0.0), 0.0,DELTA);
	}

	@Test
	public void testConstrainReturnsExpectedJustBelowMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("constrain: Did not return the expected output.", rangeObjectUnderTest.constrain(99.9), 99.9,DELTA);
	}

	@Test
	public void testConstrainReturnsExpectedOnMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("constrain: Did not return the expected output.", rangeObjectUnderTest.constrain(100), 100.0,DELTA);
	}

	@Test
	public void testConstrainReturnsExpectedJustAboveMaximum() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("constrain: Did not return the expected output.", rangeObjectUnderTest.constrain(100.1), 100.0,DELTA);
	}

	// Lab 3 Tests

	// Combine

	@Test
	public void testCombineRange1Null() {
		rangeObjectUnderTest = new Range(-100, 300);
		assertEquals("combine: Did not return the expected output.", rangeObjectUnderTest, Range.combine(null, rangeObjectUnderTest));

	}

	@Test
	public void testCombineRange2Null() {
		rangeObjectUnderTest = new Range(-100, 300);
		assertEquals("combine: Did not return the expected output.", rangeObjectUnderTest, Range.combine(rangeObjectUnderTest, null));
	}

	@Test
	public void testCombineRange1And2Null() {
		assertEquals("combine: Did not return the expected output.", Range.combine(null, null), null);
	}

	
	  @Test public void testCombineRange1And2Valid() { rangeObjectUnderTest = new
	  Range(-100, 300); rangeObjectUnderTest2 = new Range(-200, 200);
	  rangeObjectUnderTest3 = new Range(-200, 300);
	  assertEquals("combine: Did not return the expected output.", rangeObjectUnderTest3, Range.combine(rangeObjectUnderTest, rangeObjectUnderTest2)); }
	  
	
	  // expandToInclude
	  
	  @Test public void testExpandToIncludeNullRange() { rangeObjectUnderTest = new
	  Range(7, 7);
	  assertEquals("expandToInclude: Did not return the expected output.",
	  Range.expandToInclude(null, 7), rangeObjectUnderTest); }
	  
	  @Test public void testExpandToIncludeLowerRangeBoundValue() {
	  rangeObjectUnderTest = new Range(-100, 100); rangeObjectUnderTest2 = new
	  Range(-200, 100);
	  assertEquals("expandToInclude: Did not return the expected output.", rangeObjectUnderTest2, Range.expandToInclude(rangeObjectUnderTest, -200)); }
	  
	  @Test public void testExpandToIncludeHigherRangeBoundValue() {
	  rangeObjectUnderTest = new Range(-100, 100); rangeObjectUnderTest2 = new
	  Range(-100, 200);
	  assertEquals("expandToInclude: Did not return the expected output.", rangeObjectUnderTest2, Range.expandToInclude(rangeObjectUnderTest, 200)); }
	  
	  @Test public void testExpandToIncludeValueWithinRange() {
	  rangeObjectUnderTest = new Range(-100, 100);
	  assertEquals("expandToInclude: Did not return the expected output.", rangeObjectUnderTest, Range.expandToInclude(rangeObjectUnderTest, 50)); }
	 
	  // expand
	  
	  @Test public void testExpandRangeNull() { try { Range.expand(null, 0.25,
	  0.5);
	  fail("No exception thrown-Expected outcome was: a thrown exception of type: IllegalArgumentException"
	  ); } catch (Exception e) { assertTrue("Incorrect exception type thrown" +
	  e.getClass(), e.getClass().equals(IllegalArgumentException.class)); } }
	 

	@Test
	public void testExpandValidMargins() {
		rangeObjectUnderTest = new Range(2, 6);
		rangeObjectUnderTest2 = new Range(1, 8);
		assertEquals("expand: Did not return the expected output.",
				rangeObjectUnderTest2, Range.expand(rangeObjectUnderTest, 0.25, 0.5));
	}

	// shift

	@Test
	public void testShiftWithBaseAndDeltaOnly() {
		rangeObjectUnderTest = new Range(-4, 11);
		rangeObjectUnderTest2 = new Range(6, 21);
		assertEquals("shift: Did not return the expected output. ", rangeObjectUnderTest2, Range.shift(rangeObjectUnderTest, 10.0));
	}

	@Test
	public void testShiftWithBaseAndDeltaOnlyNullBase() {
		try {
			Range.shift(null, 10);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown" + e.getClass(),
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testShiftWithZeroCrossingTrue() {
		rangeObjectUnderTest = new Range(-4, 11);
		rangeObjectUnderTest2 = new Range(6, 21);
		assertEquals("shift: Did not return the expected output. ", rangeObjectUnderTest2, Range.shift(rangeObjectUnderTest, 10.0, true));
	}

	@Test
	public void testShiftWithZeroCrossingFalse() {
		rangeObjectUnderTest = new Range(-23, -4);
		rangeObjectUnderTest2 = new Range(-13, 0);
		assertEquals("shift: Did not return the expected output. ", rangeObjectUnderTest2, Range.shift(rangeObjectUnderTest, 10.0, false));
	}

	@Test
	public void testShiftWithNoZeroCrossingValue0() {
		rangeObjectUnderTest = new Range(0, 19);
		rangeObjectUnderTest2 = new Range(10, 29);
		assertEquals("shift: Did not return the expected output. ", rangeObjectUnderTest2, Range.shift(rangeObjectUnderTest, 10.0, false));
	}

	@Test
	public void testShiftWithZeroCrossingValue0() {
		rangeObjectUnderTest = new Range(0, 19);
		rangeObjectUnderTest2 = new Range(10, 29);
		assertEquals("shift: Did not return the expected output. ", rangeObjectUnderTest2, Range.shift(rangeObjectUnderTest, 10.0, true));
	}

	@Test
	public void testRangeLowerboundGreaterThanUpperbound() {
		try {
			rangeObjectUnderTest = new Range(2, 1);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown" + e.getClass(),
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

}