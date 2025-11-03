
package Race.Lap;

// Classe responsavél pela saída
public class Result {

    private short position;
    private String name;
    private short lapsCompleted;
    private TimeLap timeTotal;

    public Result(short position, String name, short lapsCompleted, TimeLap timeTotal) {
        this.position = position;
        this.name = name;
        this.lapsCompleted = lapsCompleted;
        this.timeTotal = timeTotal;
    }

    public String toString() {
        return position + " " + name + " " + lapsCompleted + " " + timeTotal;
    }

    public String getName() {
        return name;
    }

    public short getLapsCompleted() {
        return lapsCompleted;
    }

    public TimeLap getTimeTotal() {
        return timeTotal;
    }

    public short getPosition() {
        return position;
    }

    public void addTimeTotal(TimeLap time) {
        this.timeTotal.addTime(time);
    }
    
}