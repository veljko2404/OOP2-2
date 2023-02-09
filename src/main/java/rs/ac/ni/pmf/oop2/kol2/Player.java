package rs.ac.ni.pmf.oop2.kol2;

import lombok.Value;

@Value
public class Player
{
	int id;
	String name;
	String position;
	String club;
	String nationality;
	int age;

	public Player(int id, String name, String position, String club, String nationality, int age) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.club = club;
		this.nationality = nationality;
		this.age = age;
	}
}
