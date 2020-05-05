/*
Swap odd and even bits with minimum number of steps
*/
class SwapAllOddAndEvenBits {

    public long swapBits(long n) {
        // Get all even bits of n
        long even_bits = n & 0xAAAAAAAA;

        // Get all odd bits of n
        long odd_bits = n & 0x55555555;

        // Right shift even bits
        even_bits >>= 1;

        // Left shift even bits
        odd_bits <<= 1;

        // Combine even and odd bits
        return (even_bits | odd_bits);
    }
}