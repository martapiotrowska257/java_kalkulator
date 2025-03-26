package kalkulator;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testMultOneByTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testAddNegative() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.add(-1);
		assertEquals("1+(-1) = 0", 0, sut.getState());
	}

	@Test
	public void testMultiplyOneByNegative() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(-1);
		assertEquals("1*(-1) = -1", -1, sut.getState());
	}

	@Test
	public void testMultiplyOneByZero() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(0);
		assertEquals("1*0 = 0", 0, sut.getState());
	}

	@Test
	public void testSubtractOne() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.sub(1);
		assertEquals("1-1 = 0", 0, sut.getState());
	}

	@Test
	public void testSubtractNegative() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.sub(-1);
		assertEquals("1-(-1) = 2", 2, sut.getState());
	}

	@Test
	public void testDivideTenByTwo() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.div(2);
		assertEquals("10 / 2 = 5", 5, sut.getState());
	}

	@Test
	public void testDivideTenByNegative() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.div(-2);
		assertEquals("10 / (-2) = -5", -5, sut.getState());
	}

	@Test
	public void testSaveMemory() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.saveMem(); // zawiera 1
		assertEquals("Memory: 1", 1, sut.getMem());
	}

	@Test
	public void testUseMemory() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.saveMem(); // zawiera 1
		sut.useMem(); // dodaje 1
		assertEquals("1 +(M 1) = 2", 2, sut.getState());
	}

	@Test
	public void testMPlus(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.addMem();
		assertEquals("(M 0)+1 = (M 1)", 1, sut.getMem());
	}

	@Test
	public void testMMinus(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.subMem();
		assertEquals("(M 0)-1 = (M -1)", -1, sut.getMem());
	}

	@Test
	public void testDivideByZero() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.div(0);
		assertTrue("1 / 0 = err", sut.getError());
	}

	@Test
	public void testPowerByNegative() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.power(-1);
		assertTrue("1 ^(-1) = err", sut.getError());
	}

	@Test
	public void testPowerByZero() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.power(0);
		assertEquals("10 ^(0) = 1", 1, sut.getState());
	}

	@Test
	public void testPowerByThree() {
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.power(3);
		assertEquals("2 ^(3) = 8", 8, sut.getState());
	}

}
