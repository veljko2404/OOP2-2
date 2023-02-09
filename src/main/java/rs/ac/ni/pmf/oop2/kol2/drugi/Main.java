package rs.ac.ni.pmf.oop2.kol2.drugi;

import rs.ac.ni.pmf.oop2.kol2.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "football_players.csv";
        List<Player> players = readPlayersFromFile(fileName);
        String givenClub = "Juventus";
        players.stream()
                .filter(p -> p.getClub().equals(givenClub))
                .forEach(System.out::println);
    }

    private static List<Player> readPlayersFromFile(String fileName) {
        List<Player> players = new ArrayList<>();
        int counter = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                players.add(new Player(counter,data[0].trim(),data[1].trim(),data[2].trim(),data[3].trim(),Integer.parseInt(data[4].trim())));
                counter++;
            }
        } catch (FileNotFoundException e){
            System.out.println("File was not found!");
        }
        catch (IOException e) {
            System.out.println("Error occurred : other exception!");
        }
        return players;
    }
}