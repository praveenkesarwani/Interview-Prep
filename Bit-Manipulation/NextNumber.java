/*
Find the next bigger and smaller numbers for a given number with 
same number of 1 bits
*/

import java.io.*;
import java.util.*;

class NextNumber {
    public static long setBit(long num, int bitNumber) {
        return num = num | ((long) 1 << bitNumber);
    }

    public static long clearAllLowerBits(long num, int bitNumber) {
        num &= ~(((long) 1 << bitNumber) - 1);
        return num;
    }

    public static long insertOneBitsAtLowerEnd(long num, int numberOfBits) {
        num |= ((long) 1 << numberOfBits) - 1;
        return num;
    }

    public static long insertNumOneBitsAtPosition(long num, int numBits, int bitNumber) {
        long mask = ((long) 1 << (numBits)) - 1;
        num |= mask << (bitNumber);
        return num;
    }

    public long nextGreater(long n) {
        int numOfZeroBitsRightOfZeroBit = 0;
        int numOfOneBitsRightOfZeroBit = 0;
        long temp = n;
        while (((temp & 1) == 0) && (temp != 0)) {
            numOfZeroBitsRightOfZeroBit++;
            temp = temp >> 1;
        }
        while ((temp & 1) == 1) {
            numOfOneBitsRightOfZeroBit++;
            temp = temp >> 1;
        }
        // No rightmost 0 bit found such that it has 1s on its right
        if (numOfZeroBitsRightOfZeroBit + numOfOneBitsRightOfZeroBit == 63
                || numOfZeroBitsRightOfZeroBit + numOfOneBitsRightOfZeroBit == 0) {
            return -1;
        }
        int zeroBitPosition = numOfOneBitsRightOfZeroBit + numOfZeroBitsRightOfZeroBit;
        n = setBit(n, zeroBitPosition);
        n = clearAllLowerBits(n, zeroBitPosition);
        n = insertOneBitsAtLowerEnd(n, numOfOneBitsRightOfZeroBit - 1);
        return n;
    }

    public long nextSmaller(long n) {
        int numOfZeroBitsRightOfOneBit = 0;
        int numOfOneBitsRightOfOneBit = 0;
        long temp = n;
        while ((temp & 1) == 1) {
            numOfOneBitsRightOfOneBit++;
            temp = temp >> 1;
        }
        // No rightmost 1 with 0s on the right
        if (temp == 0) {
            return -1;
        }
        while (((temp & 1) == 0) && (temp != 0)) {
            numOfZeroBitsRightOfOneBit++;
            temp = temp >> 1;
        }
        int oneBitPosition = numOfZeroBitsRightOfOneBit + numOfOneBitsRightOfOneBit;
        n = clearAllLowerBits(n, oneBitPosition + 1);
        n = insertNumOneBitsAtPosition(n, numOfOneBitsRightOfOneBit + 1, numOfZeroBitsRightOfOneBit - 1);
        return n;
    }
}