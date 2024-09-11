package kz.krieger.task_manager.mapper;

import kz.krieger.task_manager.dto.TaskDTO;
import kz.krieger.task_manager.entities.TaskEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private final ModelMapper modelMapper;

    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public TaskEntity convertToClass(TaskDTO taskDTO){
        return modelMapper.map(taskDTO, TaskEntity.class);
    }
    public TaskDTO convertToDTO(TaskEntity taskEntity){
        return modelMapper.map(taskEntity, TaskDTO.class);
    }

}
