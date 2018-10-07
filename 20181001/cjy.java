    public int divide(int dividend, int divisor) {
        //判断最终结果的正负性
        boolean isPositive = true;
        if((dividend<0&&divisor>0) || (dividend>0&&divisor<0)){
            isPositive = false;
        }
        
        //判断结束后全部当做正数进行操作
        //使用long解决数值溢出情况
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if(ldivisor==0) return Integer.MAX_VALUE;
        if(ldividend==0 || ldividend<ldivisor) return 0;
        
        long result = divide(ldividend, ldivisor);
        if(result>Integer.MAX_VALUE){
            return isPositive? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(isPositive? result : -result);
    }
    
    public long divide(long ldividend, long ldivisor){
        if(ldividend<ldivisor) return 0;
        long sum = ldivisor;
        long result = 1;
        //二分法计算结果
        while(ldividend >= (sum+sum)){
            sum += sum;
            result += result;
        }
        return result + divide(ldividend-sum, ldivisor);
    }
