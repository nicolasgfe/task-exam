package com.juliano.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juliano.task.dto.TaskDTO;
import com.juliano.task.form.TaskForm;
import com.juliano.task.form.UpdateStatusTaskForm;
import com.juliano.task.form.UpdateTaskForm;
import com.juliano.task.model.Task;
import com.juliano.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task createTask(TaskForm task) {
		Task newTask = task.converter();
		return taskRepository.save(newTask);
	}

	public Task updateTask(Long id, UpdateTaskForm updateTaskForm) {
		 return taskRepository.save(updateTaskForm.converter(id, taskRepository));
	}
	
	public Task updateTask(Long id, UpdateStatusTaskForm updateStatusTaskForm) {
		return taskRepository.save(updateStatusTaskForm.converter(id, taskRepository));
	}

	public Page<TaskDTO> getAllTasks(Pageable pagination) {
		Page<Task> task = taskRepository.findAll(pagination);
		Page<TaskDTO> taskDTO = TaskDTO.converter(task);
		return taskDTO;
	}
	
	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}
