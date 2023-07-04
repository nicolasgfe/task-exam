package com.juliano.task.form;

import com.juliano.task.enumeration.TaskStatus;
import com.juliano.task.model.Task;
import com.juliano.task.repository.TaskRepository;

public class UpdateStatusTaskForm {

	//TODO Validar informações nulas, vazias.
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Task converter(Long id, TaskRepository taskRepository) {
		Task task = taskRepository.findById(id).get();
		task.setStatus(TaskStatus.valueOf(status));
		return task;
	}

	public Task converter() {
		return new Task(status);
	}

}
