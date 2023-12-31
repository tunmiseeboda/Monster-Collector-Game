/**
* MonsterType - Gets various Monster types
*
* Copyright 2023 Howard Community College
* @author Oluwatunmise Eboda
* @version 1.0
*
*/

package javaClass;

public enum MonsterType {
	GRASS("Grass"), 
	FIRE("Fire"), 
	WATER("Water"), 
	FIGHTING("Fighting"), 
	STEEL("Steel"), 
	FAIRY("Fairy");

	String readable;

	private MonsterType(String readable) {
		this.readable = readable;
	}

	 String getReadable() {
		return readable;
	}

}