package com.greenboard.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.util.Assert;

/**
 * Represents the central entity within Greenboard. Boards must have a spatial
 * location, together with an administrator who can audit the board.
 * 
 * TODO Elaborate domain model around Boards (Private/Public boards), Cards and
 * Pins.
 * 
 * 
 */
@Entity
public class Board {

	@Id
	@GeneratedValue
	@SuppressWarnings("unused")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String description;

	/**
	 * JPA Constructor.
	 */
	protected Board()
	{
		
	}
	
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
