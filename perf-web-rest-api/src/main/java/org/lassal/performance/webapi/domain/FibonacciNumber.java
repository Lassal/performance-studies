package org.lassal.performance.webapi.domain;

public class FibonacciNumber {

    private int seq0 = 0;
    private int seq1 = 1;
    private int seq = 0;
    private long fibonacciNumber = 0;

    public FibonacciNumber(int sequence){
        this.seq = sequence;

        this.fibonacciNumber = this.calculateFibonacciSequenceNumber(this.seq);
    }

    private long calculateFibonacciSequenceNumber(int seq) {
        long fiboSeq = 0;
        if(seq <= this.seq0){
            fiboSeq = 0;
        }
        else if(seq == this.seq1){
            fiboSeq = 1;
        }
        else{
            long prev = this.seq0;
            long curr = this.seq1;
            long next = curr + prev;

            for(int i=3; i <= seq; i++ ){
                prev = curr;
                curr = next;
                next = prev + curr;
            }

            fiboSeq = next;
        }

        return fiboSeq;
    }


    public long getFibonacciNumber() {
        return fibonacciNumber;
    }
}
