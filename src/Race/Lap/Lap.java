package Race.Lap;

import java.time.LocalTime;

public class Lap {
    private LocalTime time;
    private String name;
    private TimeLap lapTime;
    private int lapNumber;
    private float averageLapTime;

    public Lap(LocalTime time, String name, TimeLap lapTime, int lapNumber, float averageLapTime) {
        this.time = time;
        this.name = name;
        this.lapTime = lapTime;
        this.lapNumber = lapNumber;
        this.averageLapTime = averageLapTime;
    }

    public Lap(String time, String name, String lapNumber, String lapTime, String averageLapTime) {
        this.time = LocalTime.parse(time);
        this.name = name;
        this.lapTime = new TimeLap(lapTime);
        this.lapNumber = Integer.parseInt(lapNumber);
        this.averageLapTime = Float.parseFloat(averageLapTime.trim().replace(",", "."));
    }

    public void printLap() {
        System.out.println(time + " " + name + " " + lapTime + " " + lapNumber + " " + averageLapTime);
    }

    public LocalTime getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public TimeLap getLapTime() {
        return lapTime;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public float getAverageLapTime() {
        return averageLapTime;
    }

    public void setAverageLapTime(float averageLapTime) {
        this.averageLapTime = averageLapTime;
    }

    public void setLapTime(TimeLap lapTime) {
        this.lapTime = lapTime;
    }
}
