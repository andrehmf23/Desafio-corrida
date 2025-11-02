package Race;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Race.Lap.Lap;
import Race.Lap.Result;

public class Race {

    private ArrayList<Lap> laps = new ArrayList<>();
    private ArrayList<Result> result = new ArrayList<>();

    public Race() {
        loadLaps();
    }

    private void loadLaps() {
        File file = new File("input.txt");

        try (Scanner reader = new Scanner(file)) {

            if (reader.hasNextLine()) reader.nextLine();

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] array = data.split("\\t");

                if (array.length < 5) {
                    System.out.println("Linha inválida: " + data);
                    continue;
                }

                Lap lap = new Lap(array[0], array[1], array[2], array[3], array[4]);
                laps.add(lap);
            }
            System.out.println("[Laps carregados]");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }
    }

    public boolean sameName(String name) {
        for (Result res : result) {
            if (res.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Result resultWithName(String name) {
        for (Result res : result) {
            if (res.getName().equals(name)) {
                return res;
            }
        }
        return null;
    }

    public void processing() {
        short counter = 1;

        for (short i = 4; i > 0; i--) {
            for (Lap lap : laps) {
                if (lap.getLapNumber() == i && !sameName(lap.getName())) {
                    result.add(new Result(counter, lap.getName(), i, lap.getLapTime()));
                    counter++;
                } else if (lap.getLapNumber() == i) {
                    Result res = resultWithName(lap.getName());
                    res.addTimeTotal(lap.getLapTime());
                }
            }
        }

        
        for (Result res : result) {
            System.out.println(res.toString());
        }
    }

    public void printLaps() {
        for (Lap lap : laps) {
            lap.printLap();
        }
    }
}
