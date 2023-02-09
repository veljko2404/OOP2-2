package rs.ac.ni.pmf.oop2.kol2.treci;

import rs.ac.ni.pmf.oop2.kol2.Player;

import java.util.*;
import java.util.function.Function;

import static rs.ac.ni.pmf.oop2.kol2.PlayersRepository.getFootballPlayers2012;

public class Main {
    public static <T> void sortList(List<T> list, Function<T, Integer> mapper){
        list.sort(Comparator.comparingInt(mapper::apply));
    }

    public static void main(String[] args) {
        List<Player> players = getFootballPlayers2012();

        sortList(players, Player::getAge);
        System.out.println("Sorting players by age:");
        for(Player player : players){
            System.out.println(player);
        }

        sortList(players, p -> p.getName().length());
        System.out.println("Sorting players by length of name:");
        for(Player player : players){
            System.out.println(player);
        }
    }
}
