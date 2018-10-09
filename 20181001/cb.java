package com.ctrip.hotel.order.processservice.soa;

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        //结果是否为负
        boolean isNegative = false;
        if ((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0)) {
            isNegative = true;
        }

        int result = 0;
        int dividendCopy = dividend, divisorCopy = divisor;

        if (dividendCopy == Integer.MIN_VALUE) {
            if (isNegative) {
                dividendCopy = dividendCopy + divisorCopy;
            } else {
                dividendCopy = dividendCopy - divisorCopy;
            }
            result++;
        }
        if (divisorCopy == Integer.MIN_VALUE) {
            return result;
        }

        if (dividendCopy < 0) {
            dividendCopy = -dividendCopy;
        }
        if (divisorCopy < 0) {
            divisorCopy = -divisorCopy;
        }

        int bitIndex = getBitIndex(dividendCopy, divisorCopy);
        while (bitIndex >= 0) {
            dividendCopy = dividendCopy - (divisorCopy << bitIndex);
            result = result + (1 << bitIndex);
            bitIndex = getBitIndex(dividendCopy, divisorCopy);
        }

        if (isNegative) {
            result = -result;
        }

        return result;
    }

    //计算divisorCopy小于dividendCopy的最大移位
    private int getBitIndex(int dividendCopy, int divisorCopy) {
        int tmp, bitNums = 31;
        for (int i = 0; i < bitNums; i++) {
            tmp = dividendCopy - (divisorCopy << i);
            if (tmp < 0) {
                return i - 1;
            }
        }

        return bitNums - 1;
    }
}
