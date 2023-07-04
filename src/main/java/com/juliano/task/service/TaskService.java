package com.juliano.task.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juliano.task.dto.TaskDTO;
import com.juliano.task.form.TaskForm;
import com.juliano.task.form.UpdateStatusTaskForm;
import com.juliano.task.form.UpdateTaskForm;
import com.juliano.task.model.Task;
import com.juliano.task.repository.TaskRepository;

//TODO Anotação para o serviço
public class TaskService {

	//TODO Realizar a injeção de dependencia.
	private TaskRepository taskRepository;

	public Task createTask(TaskForm task) {
		//TODO Criar a atividade e realezar a conversão do taskFrom para task.
	}

	public Task updateTask(Long id, UpdateTaskForm updateTaskForm) {
		//TODO Atualizar a atividade e realezar a conversão do updateTaskForm para task.
	}
	
	public Task updateTask(Long id, UpdateStatusTaskForm updateStatusTaskForm) {
		//TODO Atualizar a o status da atividade e realezar a conversão do updateStatusTaskForm para task.
	}

	public Page<TaskDTO> getAllTasks(Pageable pagination) {
		//TODO Recuperar a lista usando paginação.
		//TODO Converter o tasks para tasksDTO.
	}
	
	public Optional<Task> findById(Long id) {
		//TODO Recuperar a task por id.
	}

	public void deleteTask(Long id) {
		//TODO Deletar a task.
	}
}
