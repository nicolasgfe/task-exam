package com.juliano.task.form;

import com.juliano.task.enumeration.TaskStatus;
import com.juliano.task.model.Task;
import com.juliano.task.repository.TaskRepository;

public class TaskForm {
	//TODO Validar informações nulas, vazias e tamanho maximo de 60.
	private String title;

	//TODO Validar informações nulas, vazias e tamanho maximo de 300.
	private String description;

	//TODO Validar informações nulas, vazias.
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Task converter(Long id, TaskRepository taskRepository) {
		Task task = taskRepository.findById(id).get();
		task.setTitle(title);
		task.setDescription(description);
		task.setStatus(TaskStatus.PENDING);
		return task;
	}
	
	public Task converter() {
		return new Task(title, description, status);
	}

}
