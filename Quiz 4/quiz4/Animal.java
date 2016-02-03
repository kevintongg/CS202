package quiz4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Animal {

    private ArrayList<Animal> animals = new ArrayList<>();
    private String fileName;

    public Animal(ArrayList<Animal> animals, String fileName) {
        this.animals = animals;
        this.fileName = fileName;
    }

    public static void writeAnimalsToFile(ArrayList<Animal> animals, String fileName) {

        Charset charset = Charset.forName("UTF-8");
        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            for (int i = 0; i < animals.size(); i++) {
                String rows = " ";
                for (int j = 0; j < animals.size(); j++) {

                }
            }
        }
        catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        String animal[][] = new String[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first row of animals, separated by commas:");
        animal[1] = sc.nextLine().split(",");
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
