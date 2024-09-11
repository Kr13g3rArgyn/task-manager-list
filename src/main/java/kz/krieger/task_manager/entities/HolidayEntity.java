package kz.krieger.task_manager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class HolidayEntity {
    @Id
    private Long id;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private List<String> types;
}