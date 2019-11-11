package garbagecoll;

public class Main {
    public static void main(String[] args) {
        MemoryStat statistics = new MemoryStat();
        statistics.gatherGCStatistics();
    }
}