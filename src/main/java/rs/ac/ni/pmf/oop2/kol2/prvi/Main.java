package rs.ac.ni.pmf.oop2.kol2.prvi;

import rs.ac.ni.pmf.oop2.kol2.Player;

import java.time.Year;
import java.util.*;

import static rs.ac.ni.pmf.oop2.kol2.PlayersRepository.getFootballPlayers2012;

public class Main {
    public static void main(String[] args) {
        List<Player> players = getFootballPlayers2012();
        String givenCountry = "Spain";

        long numberOfPlayers = players.stream()
                .filter(p -> p.getNationality().equals(givenCountry))
                .count();
        System.out.printf("Number of players from %s is %d\n", givenCountry, numberOfPlayers);

        String givenClub = "Real Madrid";

        try {
            double averageAge = players.stream()
                    .filter(p -> p.getClub().equals(givenClub))
                    .mapToDouble(Player::getAge)
                    .average()
                    .orElseThrow(NoPlayersFoundException::new);
            System.out.printf("Average age player in %s is %f\n", givenClub, averageAge);
        } catch (NoPlayersFoundException e) {
            System.out.println("No players found!");
        }

        int givenYear = 2021;
        int currentYear = Year.now().getValue();

        players.stream()
                .filter(p -> p.getAge() >= 40 - (currentYear - givenYear))
                .map(Player::getName)
                .forEach(System.out::println);

        String givenPosition = "forward";
        System.out.printf("List of players who plays on position %s:\n", givenPosition);

        players.stream()
                .filter(p -> p.getPosition().toLowerCase().contains(givenPosition))
                .sorted(Comparator.comparing(Player::getClub)
                        .thenComparing(Player::getAge))
                .forEach(System.out::println);
    }
}
