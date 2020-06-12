// Find the number of bits needed to convert Int X to Int Y
class Conversion {
    // Function that count set bits
    public int countSetBits(long n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int countConversionBits(long a, long b) {
        // a XOR b
        return countSetBits(a ^ b);
    }
}
