package math;

public class UrnModel {
    public static float urnModelFirst(int n, int m, int k) {
        long combFromMToK = Combinations.combinations(m,k);
        long combFromNToK = Combinations.combinations(n,k);
        return (float)combFromMToK/combFromNToK;
    }
    public static float urnModelSecond(int n, int m, int k,int r) {
        long combFromMToR = Combinations.combinations(m,r);
        long combFromNToK = Combinations.combinations(n,k);
        long combSubtraction = Combinations.combinations((n-m),(k-r));
        return (float)(combFromMToR*combSubtraction)/combFromNToK;
    }
}
