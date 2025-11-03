package Race.Lap;

import java.time.LocalTime;

// Classe responsavél pela entrada
public class Lap {
    private LocalTime time;
    private String name;
    private TimeLap lapTime;
    private int lapNumber;
    private float averageLapTime;

    public Lap(LocalTime time, String name, int lapNumber, TimeLap lapTime, float averageLapTime) {
        this.time = time;
        this.name = name;
        this.lapNumber = lapNumber;
        this.lapTime = lapTime;
        this.averageLapTime = averageLapTime;
    }

    public Lap(String time, String name, String lapNumber, String lapTime, String averageLapTime) {
        this.time = LocalTime.parse(time);
        this.name = name;
        this.lapNumber = Integer.parseInt(lapNumber);
        this.lapTime = new TimeLap(lapTime);
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
