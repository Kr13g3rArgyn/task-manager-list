package kz.krieger.task_manager.services;

import jakarta.transaction.Transactional;
import kz.krieger.task_manager.dto.TaskDTO;
import kz.krieger.task_manager.entities.TaskEntity;
import kz.krieger.task_manager.mapper.TaskMapper;
import kz.krieger.task_manager.repository.TaskEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class TaskService {

    private final TaskEntityRepository taskEntityRepository;
    private final TaskMapper taskMapper;
    @Autowired
    public TaskService(TaskEntityRepository taskEntityRepository, TaskMapper taskMapper) {
        this.taskEntityRepository = taskEntityRepository;
        this.taskMapper = taskMapper;
    }


    public List<TaskEntity> getTasks(){
        return taskEntityRepository.findAll().stream().toList();
    }
    public List<TaskEntity> getTaskById(Long id){
        return taskEntityRepository.findById(id).stream().toList();
    }

    public TaskEntity createTask(TaskEntity taskEntity){
        return taskEntityRepository.save(taskEntity);
    }

    public TaskDTO updateTask(Long id, TaskDTO updatedTask) {
        Optional<TaskEntity> existingTask = taskEntityRepository.findById(id);
        if (existingTask.isPresent()){
            TaskEntity taskToUpdate = existingTask.get();
            taskToUpdate.setTitle(updatedTask.getTitle());
            taskToUpdate.setDescription(updatedTask.getDescription());
            taskToUpdate.setDone(updatedTask.isDone());
            return taskMapper.convertToDTO(taskToUpdate);
        }else {
            throw new RuntimeException("Couldn't update task by ["+id + "] - id!");
        }
    }

}
