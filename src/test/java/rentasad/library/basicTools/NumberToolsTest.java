package rentasad.library.basicTools;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberToolsTest
{
    @Test
    public void testRandomGeneratorValidRange() throws Exception {
        List<Integer> numbers = NumberTools.randomGenerator(1, 10, 5);
        assertEquals(5, numbers.size());
        for (Integer num : numbers) {
            assertTrue(num >= 1 && num <= 10);
        }
    }

    @Test
    public void testRandomGeneratorEdgeCases() throws Exception {
        List<Integer> numbers = NumberTools.randomGenerator(5, 5, 1);
        assertEquals(1, numbers.size());
        assertEquals(5, (int) numbers.get(0));
    }

    @Test
    public void testRandomGeneratorInvalidRange() throws Exception {
     	assertThrows(IllegalArgumentException.class, () ->NumberTools.randomGenerator(10, 1, 5));
    }

    @Test
    public void testRandomGeneratorZeroCount() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> NumberTools.randomGenerator(1, 10, 0));
    }
    @Test
    public void testCustomFormat() throws Exception
    {
        assertEquals("123,46", NumberTools.customFormat("#.##", 123.456));
        assertEquals("0000123,46", NumberTools.customFormat("0000000.00", 123.456));
        assertEquals("123,4560", NumberTools.customFormat("#.0000", 123.456));
        assertEquals("123,46", NumberTools.customFormat("##,##,###.##", 123.456));
        assertEquals("1,23E2", NumberTools.customFormat("0.##E0", 123.456));
    }


	@Test
	public void testGetLeadingZero() throws Exception
	{
		assertEquals("02", NumberTools.getLeadingZero(2));
	}

	@Test
	public void testIsNumericPositive() throws Exception
	{
		assertTrue(NumberTools.isNumeric("123"));
		assertTrue(NumberTools.isNumeric("123.45"));
		assertTrue(NumberTools.isNumeric("-123.45"));
		assertTrue(NumberTools.isNumeric("0"));
		assertTrue(NumberTools.isNumeric("0.12345"));
	}

	@Test
	public void testIsNumericNegative() throws Exception
	{
		assertFalse(NumberTools.isNumeric("abc"));
		assertFalse(NumberTools.isNumeric("123abc"));
		assertFalse(NumberTools.isNumeric(""));
		assertFalse(NumberTools.isNumeric("12.34.56"));
		assertFalse(NumberTools.isNumeric("--123"));
	}


    @Test
    public void testIsNumericIntegerPositive() throws Exception
    {
        assertTrue(NumberTools.isNumericInteger("123"));
        assertTrue(NumberTools.isNumericInteger("-123"));
        assertTrue(NumberTools.isNumericInteger("0"));
    }

    @Test
    public void testIsNumericIntegerNegative() throws Exception
    {
        assertFalse(NumberTools.isNumericInteger("123.45"));
        assertFalse(NumberTools.isNumericInteger("abc"));
        assertFalse(NumberTools.isNumericInteger("123abc"));
        assertFalse(NumberTools.isNumericInteger(""));
        assertFalse(NumberTools.isNumericInteger("12.34.56"));
        assertFalse(NumberTools.isNumericInteger("--123"));
    }
    @Test
    public void testIsNumericLongPositive() throws Exception {
        assertTrue(NumberTools.isNumericLong("123456789012345"));
        assertTrue(NumberTools.isNumericLong("-123456789012345"));
        assertTrue(NumberTools.isNumericLong("0"));
    }

    @Test
    public void testIsNumericLongNegative() throws Exception {
        assertFalse(NumberTools.isNumericLong("123456789012345.67"));
        assertFalse(NumberTools.isNumericLong("abc"));
        assertFalse(NumberTools.isNumericLong("123abc"));
        assertFalse(NumberTools.isNumericLong(""));
        assertFalse(NumberTools.isNumericLong("12.34.56"));
        assertFalse(NumberTools.isNumericLong("--123456789012345"));
    }


	@Test
	public void testConvertBooleanToIntTrue()
	{
		assertEquals(1, NumberTools.convertBooleanToInt(true));
	}

	@Test
	public void testConvertBooleanToIntFalse()
	{
		assertEquals(0, NumberTools.convertBooleanToInt(false));
	}
    @Test
    public void testRoundPositiveNumbers() {
        assertEquals(123.46, NumberTools.round(123.456, 2));
        assertEquals(123.457, NumberTools.round(123.4567, 3));
        assertEquals(123.0, NumberTools.round(123.456, 0));
    }

    @Test
    public void testRoundNegativeNumbers() {
        assertEquals(-123.46, NumberTools.round(-123.456, 2));
        assertEquals(-123.457, NumberTools.round(-123.4567, 3));
        assertEquals(-123.0, NumberTools.round(-123.456, 0));
    }

    @Test
    public void testRoundZero() {
        assertEquals(0.0, NumberTools.round(0, 2));
        assertEquals(0.0, NumberTools.round(0, 0));
    }

    @Test
    public void testRoundEdgeCases() {
        assertEquals(1.0, NumberTools.round(0.9999, 0));
        assertEquals(0.9999, NumberTools.round(0.99994, 4));
    }
}