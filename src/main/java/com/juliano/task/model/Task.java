package com.juliano.task.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.juliano.task.enumeration.TaskStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

//TODO
// Realizar as anotações da entidade
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	//TODO Primary Key
	private Long id;

	//TODO Definir como notnull
	private String title;

	//TODO Definir como notnull
	private String description;

	//TODO Definir como notnull
	private LocalDateTime creationDate;

	@Enumerated(EnumType.STRING)
	//TODO Definir como notnull
	private TaskStatus status;

	public Task() {
	}

	public Task(String title, String description, String status) {
		super();
		this.title = title;
		this.description = description;
		this.status = TaskStatus.valueOf(status);
		this.creationDate = LocalDateTime.now();
	}

	public Task(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Task(String status) {
		super();
		this.status = TaskStatus.valueOf(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
