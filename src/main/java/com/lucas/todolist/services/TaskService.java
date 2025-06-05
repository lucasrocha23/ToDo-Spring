package com.lucas.todolist.services;

import com.lucas.todolist.dto.TaskRequestDTO;
import com.lucas.todolist.model.Task;
import com.lucas.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    //Criando tarefa
    public Task saveTask(TaskRequestDTO task){
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setStatus("pendente");
        newTask.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(newTask);
    }

    //Lendo tarefas
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTask(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    //Atualizando tarefa
    public Task updateTask(Long id,TaskRequestDTO updatedTask){
        return taskRepository.findById(id).map( task-> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        }).orElse(null);
    }

    //Excluindo tarefa
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
