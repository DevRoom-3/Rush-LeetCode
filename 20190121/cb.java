package com.ctrip.hotel.order.processservice.soa;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String args[]) throws Exception {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        Interval newInterval = new Interval(2, 7);

        System.out.println(new Solution().insert(intervals, newInterval));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty() && newInterval != null) {
            intervals.add(newInterval);
            return intervals;
        } else if (newInterval == null) {
            return intervals;
        }

        List<Interval> res = new ArrayList<>();
        boolean flag = false;

        Integer start = null, end = null;
        for (Interval interval : intervals) {
            if (flag) {
                if (start != null) {
                    if (interval.start > newInterval.end) {
                        end = newInterval.end;
                        res.add(new Interval(start, end));
                        start = interval.start;
                        end = interval.end;
                    } else {
                        if (interval.end >= newInterval.end) {
                            end = interval.end;
                        }
                    }
                } else {
                    res.add(interval);
                }
            } else {
                if (interval.start >= newInterval.start) {
                    start = newInterval.start;
                    flag = true;
                    if (interval.start > newInterval.end) {
                        end = newInterval.end;
                        res.add(new Interval(start, end));
                        start = interval.start;
                        end = interval.end;
                    } else {
                        if (interval.end >= newInterval.end) {
                            end = interval.end;
                        }
                    }
                } else {
                    start = interval.start;
                    if (interval.end >= newInterval.start) {
                        flag = true;
                        if (interval.end >= newInterval.end) {
                            end = interval.end;
                        }
                    } else {
                        end = interval.end;
                    }
                }
            }

            if (end != null) {
                res.add(new Interval(start, end));
                start = null;
                end = null;
            }
        }

        if (!flag) {
            res.add(newInterval);
        } else {
            if (start != null) {
                res.add(new Interval(start, newInterval.end));
            }
        }

        return res;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}