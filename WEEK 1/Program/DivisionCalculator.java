public class DivisionCalculator /{

    public static void main(String[] args) {
        int dividend = 50;
        int divisor = 7;

        Result result = divide(dividend, divisor);

        final String QUOTIENT_MSG = "The quotient is: ";
        final String REMAINDER_MSG = "The remainder is: ";

        System.out.println(QUOTIENT_MSG + result.quotient);
        System.out.println(REMAINDER_MSG + result.remainder);
    }

    private static Result divide(int dividend, int divisor) {
        int quotient = 0;
        int remainder = dividend;

        while (remainder >= divisor) {
            remainder -= divisor;
            quotient++;
        }

        return new Result(quotient, remainder);
    }

    private static class Result {
        int quotient;
        int remainder;

        Result(int quotient, int remainder) {
            this.quotient = quotient;
            this.remainder = remainder;
        }
    }
}
