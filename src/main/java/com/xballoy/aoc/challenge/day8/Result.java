package com.xballoy.aoc.challenge.day8;

public class Result {

    private Status status;
    private int position;
    private int accumulator;

    public Result() {
        this.status = Status.RUNNING;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPosition() {
        return this.position;
    }

    public int getAccumulator() {
        return this.accumulator;
    }

    public void accumulate(int argument) {
        this.position += 1;
        this.accumulator += argument;
    }

    public void jump(int argument) {
        this.position += argument;
    }

    public void noop() {
        this.position +=1;
    }

}
