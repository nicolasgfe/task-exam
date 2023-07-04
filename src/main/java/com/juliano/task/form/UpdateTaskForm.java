package com.juliano.task.form;

import com.juliano.task.model.Task;
import com.juliano.task.repository.TaskRepository;

public class UpdateTaskForm {
	//TODO Validar informações nulas, vazias e tamanho maximo de 60.
	private String title;

	//TODO Validar informações nulas, vazias e tamanho maximo de 300.
	private String description;

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
	
	public Task converter(Long id, TaskRepository taskRepository) {
		Task task = taskRepository.findById(id).get();
		task.setTitle(title);
		task.setDescription(description);
		return task;
	}
	
	public Task converter() {
		return new Task(title, description);
	}

}
