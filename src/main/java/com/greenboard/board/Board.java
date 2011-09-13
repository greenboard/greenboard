package com.greenboard.board;

import javax.persistence.Entity;

import org.springframework.util.Assert;

/**
 * Represents the central entity within Greenboard. Boards must have a spatial
 * location, together with an administrator who can audit the board.
 * 
 * TODO Elaborate domain model around Boards (Private/Public boards), Cards and
 * Pins.
 * 
 * @author Anu
 * 
 */
@Entity
public class Board {

	private String name;
	private String description;

	public Board(String name) {
		Assert.notNull(name, "name cannot be null");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
