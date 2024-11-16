package rentasad.library.basicTools;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Utility class for various number-related operations such as formatting, parsing,
 * and generating random numbers.
 */
public class NumberTools
{
    /**
     * Checks if the provided string can be parsed into a double.
     *
     * @param number the string to be checked
     * @return true if the string can be parsed into a double, false otherwise
     */
    public static boolean isNumeric(final String number)
    {
        try
        {
            @SuppressWarnings("unused")
			final double d = Double.parseDouble(number);
        } catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    /**
     * Checks if the provided string can be parsed into an integer.
     *
     * @param number the string to be checked
     * @return true if the string can be parsed into an integer, false otherwise
     */
    public static boolean isNumericInteger(final String number)
    {
        try
        {
            @SuppressWarnings("unused")
            final int intValue = Integer.parseInt(number);
        } catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    /**
     * Checks if the provided string can be parsed into a long integer.
     *
     * @param number the string to be checked
     * @return true if the string can be parsed into a long integer, false otherwise
     */
    public static boolean isNumericLong(final String number)
    {
        try
        {
            @SuppressWarnings("unused")
            final long intValue = Long.parseLong(number);
        } catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    /**
     * Formats the given number to ensure it has at least two digits, adding a leading zero if necessary.
     *
     * @param number the number to format
     * @return a string representation of the number with at least two digits
     */
    public static String getLeadingZero(int number)
    {
        return String.format("%02d", number);
    }

    /**
     *
     * Description: Formatiert Nummer nach Pattern und gibt String zurueck
     *
     *
     * <tbody>
     * <tr>
     * <th id="h101">Value</th>
     * <th id="h102">Pattern</th>
     * <th id="h103">Output</th>
     * <th id="h104">Explanation</th>
     * </tr>
     * <tr>
     * <td headers="h101">123456.789</td>
     * <td headers="h102">###,###.###</td>
     * <td headers="h103">123,456.789</td>
     * <td headers="h104">The pound sign (#) denotes a digit, the comma is a placeholder for the grouping separator, and the period is a placeholder for the decimal separator.</td>
     * </tr>
     * <tr>
     * <td headers="h101">123456.789</td>
     * <td headers="h102">###.##</td>
     * <td headers="h103">123456.79</td>
     * <td headers="h104">The <code>value</code> has three digits to the right of the decimal point, but the <code>pattern</code> has only two. The <code>format</code> method handles this by rounding
     * up.</td>
     * </tr>
     * <tr>
     * <td headers="h101">123.78</td>
     * <td headers="h102">000000.000</td>
     * <td headers="h103">000123.780</td>
     * <td headers="h104">The <code>pattern</code> specifies leading and trailing zeros, because the 0 character is used instead of the pound sign (#).</td>
     * </tr>
     * <tr>
     * <td headers="h101">12345.67</td>
     * <td headers="h102">$###,###.###</td>
     * <td headers="h103">$12,345.67</td>
     * <td headers="h104">The first character in the <code>pattern</code> is the dollar sign ($). Note that it immediately precedes the leftmost digit in the formatted <code>output</code>.</td>
     * </tr>
     * </tbody>
     * </table>
     *
     * @param pattern
     * @param value
     *            Creation: 25.04.2016 by mst
     */
    public static String customFormat(String pattern, double value) {
        DecimalFormat decimalFormatter = new DecimalFormat(pattern); // Variable umbenennen für bessere Lesbarkeit
		// Variable eingeführt für bessere Verständlichkeit
		return decimalFormatter.format(value); // Direkte Rückgabe der formatierten Zeichenfolge
    }


    public static List<Integer> randomGenerator(int min, int max, int count)
    {
        return generateRandomNumbers(min, max, count);
    }

    /**
     * Generates a list of unique random integers within a specified range.
     *
     * @param min the minimum value of the range (inclusive)
     * @param max the maximum value of the range (inclusive)
     * @param count the number of random integers to generate
     * @return a list of unique random integers within the specified range
     * @throws IllegalArgumentException if the input parameters are invalid
     */
    public static List<Integer> generateRandomNumbers(int min, int max, int count) {
        validateInput(min, max, count);

        final List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        int range = (max - min) + 1;

        while (randomNumbers.size() < count) {
            int randomNumber = random.nextInt(range) + min;
            if (!randomNumbers.contains(randomNumber) && randomNumber > 0) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    /**
     * Validates the input parameters for generating random numbers.
     * Ensures that the minimum value is less than the maximum value, the count of numbers to generate is positive,
     * and the count does not exceed the range difference.
     *
     * @param min   the minimum value of the range
     * @param max   the maximum value of the range
     * @param count the number of random integers to generate
     * @throws IllegalArgumentException if the input parameters are invalid
     */
    private static void validateInput(int min, int max, int count) {
        if (min > max || count < 1) {
            throw new IllegalArgumentException("Min should be less than Max and count should be positive.");
        }

        int difference = (max - min) + 1;
        if (count > difference) {
            throw new IllegalArgumentException("Count shouldn't be greater than the difference between Min and Max.");
        }
    }

    /**
     * Converts a boolean value to an integer.
     *
     * @param booleanValue the boolean value to convert
     * @return 1 if the boolean value is true, 0 if the boolean value is false
     */
    public static int getIntFromBoolean(boolean booleanValue)
    {
        return convertBooleanToInt( booleanValue);
    }

    /**
     * Converts a boolean value to an integer representation.
     *
     * @param booleanValue the boolean value to convert
     * @return 1 if the boolean value is true, 0 if the boolean value is false
     */
    public static int convertBooleanToInt(boolean booleanValue) {
        final int TRUE_AS_INT = 1;
        final int FALSE_AS_INT = 0;

        return booleanValue ? TRUE_AS_INT : FALSE_AS_INT;
    }

    /**
     * Rounds the specified value to a given number of decimal places.
     *
     * @param value the double value to be rounded
     * @param decimalPoints the number of decimal places to round to
     * @return the rounded value as a double
     */
     public static double round(double value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
     }

}
