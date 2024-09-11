package kz.krieger.task_manager.repository;

import kz.krieger.task_manager.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long> {
}
