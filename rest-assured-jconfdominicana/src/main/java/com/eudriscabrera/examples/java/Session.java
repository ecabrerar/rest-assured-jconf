/**
 * 
 */
package com.eudriscabrera.examples.java;

/**
 * @author ecabrerar
 *
 */
public class Session {

	private Integer id;
	private String title;
	private String speaker;
	private String time;

	public Session() {
		super();
	}	

	public Session(Integer id, String title, String speaker, String time) {
		super();
		this.id = id;
		this.title = title;
		this.speaker = speaker;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
