package com.juliano.task.controller;

import com.juliano.task.model.Task;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jdk.jfr.Description;
import org.hibernate.query.ReturnableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.juliano.task.dto.TaskDTO;
import com.juliano.task.form.TaskForm;
import com.juliano.task.form.UpdateStatusTaskForm;
import com.juliano.task.form.UpdateTaskForm;
import com.juliano.task.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
@Description("Tasskkkk")
public class TaskController {
	@Autowired

	private TaskService taskService;

	@PostMapping
	@Transactional
	@Operation(description = "Created new task")
	public ResponseEntity<TaskDTO> createTask(@RequestBody @Valid TaskForm taskForm) {
		Task created = taskService.createTask(taskForm);
		return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTO(created));
		}

	@PutMapping("/{id}")
	@Transactional
	@Operation(description = "Updated Task")
	public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody @Valid UpdateTaskForm task) {
		Optional<Task> optional = taskService.findById(id);
		if (optional.isPresent()) {
			Task updated = taskService.updateTask(id, task);
			return ResponseEntity.ok(new TaskDTO(updated));
		}
		return ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}")
	@Transactional
	@Operation(description = "Updated status task")
	public ResponseEntity<TaskDTO> updateStatusTask(@PathVariable Long id, @RequestBody @Valid UpdateStatusTaskForm task) {
		Optional<Task> optional = taskService.findById(id);
		if (optional.isPresent()){
			Task updated = taskService.updateTask(id, task);
			return ResponseEntity.ok(new TaskDTO(updated));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	@Operation(description = "Find Tasks")
	public ResponseEntity<Page<TaskDTO>> getAllTasks(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		return ResponseEntity.ok(taskService.getAllTasks(pagination));
	}

	@DeleteMapping("/{id}")
	@Transactional
	@Operation(description = "Delete Task")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		Optional<Task> optional = taskService.findById(id);
		if (optional.isPresent()) {
			taskService.deleteTask(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
