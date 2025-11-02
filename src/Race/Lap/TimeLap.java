package Race.Lap;

public class TimeLap {
    private short minutes;
    private float secunds;

    public TimeLap(short minutes, short secunds, float millisecunds) {
        this.minutes = minutes;
        this.secunds = secunds;
    }

    public TimeLap(String time) {
        if (time == null) {
            throw new IllegalArgumentException("Tempo inválido: " + time);
        }

        String[] timeArray = time.trim().split(":");

        if (timeArray.length != 2) {
            throw new IllegalArgumentException("Tempo inválido: " + time);
        }

        try {
            this.minutes = Short.parseShort(timeArray[0]);
            // Substitui vírgula por ponto se necessário
            this.secunds = Float.parseFloat(timeArray[1].replace(",", "."));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Erro ao converter tempo: " + time, e);
        }
    }

    public String toString() {
        return minutes + ":" + secunds;
    }
}
