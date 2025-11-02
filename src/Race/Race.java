package Race;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Race.Lap.Lap;

public class Race {
    private ArrayList<Lap> laps = new ArrayList<>();
    
    public void loadRace() {
        File file = new File("input.txt");

        try (Scanner reader = new Scanner(file)) {
            reader.nextLine();
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
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Lap lap : laps) {
            lap.printLap();
        }
    }
}
