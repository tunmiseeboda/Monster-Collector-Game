/**
* Trainer - Shows the trainers information for the monster collector game
*
* Copyright 2023 Howard Community College
* @author Oluwatunmise Eboda
* @version 1.0
*
*/

package javaClass;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
	private String name;
	private int battlesWon;
	private double money;
	private List<Monster> team;
	private int activeMonsterIndex;

	public Trainer(String name, double money, Monster starter) {
		this.name = name;
		this.money = money;
		this.battlesWon = 0;
		this.team = new ArrayList<>();
		this.team.add(starter);
		this.activeMonsterIndex =0;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getBattlesWon() {
		return battlesWon;
	}
	
	public void setBattlesWon(int battlesWon) {
		this.battlesWon = battlesWon;
	}
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public List<Monster> getTeam() {
		return team;
	}
	
	public void setTeam (List<Monster> team) {
		this.team = team;
	}
	
	public int getActiveMonsterIndex() {
		return activeMonsterIndex;
	}
	
	public void setActiveMonsterIndex(int activeMonsterIndex) {
		this.activeMonsterIndex = activeMonsterIndex;
	}
	public String toString() {
		return "Trainer [" + 
				"name=" + name + 
				", battlesWon=" + battlesWon + 
				", money=" + money+ 
				", team=" + team + 
				", activeMonster=" + team.get(activeMonsterIndex) + 
				']';
	}

}
