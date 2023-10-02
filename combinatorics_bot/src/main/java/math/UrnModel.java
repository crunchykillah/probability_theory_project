package math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class UrnModel {
    public static BigDecimal urnModelFirst(int n, int m, int k) {
        BigInteger combFromMToK = Combinations.combinations(m, k);
        BigInteger combFromNToK = Combinations.combinations(n, k);
        BigDecimal result = new BigDecimal(combFromMToK).divide(new BigDecimal(combFromNToK), 7, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    public static BigDecimal urnModelSecond(int n, int m, int k, int r) {
        BigInteger combFromMToR = Combinations.combinations(m, r);
        BigInteger combFromNToK = Combinations.combinations(n, k);
        BigInteger combSubtraction = Combinations.combinations(n - m, k - r);
        BigDecimal result = new BigDecimal(combFromMToR.multiply(combSubtraction))
                .divide(new BigDecimal(combFromNToK), 7, BigDecimal.ROUND_HALF_UP);
        return result;
    }
}
