package com.juliano.task.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import com.juliano.task.dto.TaskDTO;
import com.juliano.task.form.TaskForm;
import com.juliano.task.form.UpdateStatusTaskForm;
import com.juliano.task.form.UpdateTaskForm;
import com.juliano.task.service.TaskService;

//TODO Anotação do controlador e mapear a URL
public class TaskController {
	// TODO Realizar a injeção de dependencia
	private TaskService taskService;

	// TODO Adicionar o verbo HTTP.
	// TODO Controlar a transão.
	//TODO Realizar as anotações do swaager.
	public ResponseEntity<TaskDTO> createTask(
		//TODO Recuparar dados e adicionar validação 
		TaskForm taskForm) {
		//TODO Criar a atividade.
		//TODO Converter a task para TaskDTO.
		//TODO Retornar o status HTTP correto.
	}

	// TODO Adicionar o verbo HTTP e vincular a variavel de caminho.
	// TODO Controlar a transão.
	//TODO Realizar as anotações do swaager.
	public ResponseEntity<TaskDTO> updateTask(
		//TODO Vincular a variavel de caminho 
		Long id, 
		//TODO Recuparar dados e adicionar validação 
		UpdateTaskForm task) {
		//TODO Recuperar a atividade.
		//TODO Verificar se ela existe.
		//TODO Tratar erros caso não existe a atividade e status HTTP corretos.
		//TODO Atualizar a atividade
		//TODO Converter para task para taskDTO.
	}

	// TODO Adicionar o verbo HTTP e vincular a variavel de caminho.
	// TODO Controlar a transão.
	// TODO Realizar as anotações do swaager.
	public ResponseEntity<TaskDTO> updateStatusTask(
		//TODO Vincular a variavel de caminh 
		Long id, 
		//TODO Recuparar dados e adicionar validação
		UpdateStatusTaskForm task) {
		//TODO Recuperar a atividade.
		//TODO Verificar se ela existe.
		//TODO Tratar erros caso não existe a atividade e status HTTP corretos.
		//TODO Atualizar a atividade
		//TODO Converter para task para taskDTO.
	}

	// TODO Adicionar o verbo HTTP.
	//TODO Realizar as anotações do swaager.
	public ResponseEntity<Page<TaskDTO>> getAllTasks(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		//TODO Recuperar a atividade.
		//TODO Retornar o status HTTP correto.
	}

	// TODO Adicionar o verbo HTTP e vincular a variavel de caminho.
	// TODO Controlar a transão.
	//TODO Realizar as anotações do swaager.
	public ResponseEntity<Void> deleteTask(//
		//TODO Vincular a variavel de caminho 
		Long id) {
		//TODO Recuperar a atividade.
		//TODO Verificar se ela existe.
		//TODO Tratar erros caso não existe a atividade e status HTTP corretos.
		//TODO Deletar a atividade
	}
}
