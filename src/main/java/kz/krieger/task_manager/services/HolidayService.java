package kz.krieger.task_manager.services;

import jakarta.persistence.Cacheable;
import kz.krieger.task_manager.components.ApplicationProperties;
import kz.krieger.task_manager.entities.HolidayEntity;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class HolidayService {
    private final RestTemplate restTemplate;
    private final String apiUrl;
    public HolidayService(RestTemplateBuilder restTemplateBuilder, ApplicationProperties applicationProperties, String apiUrl) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiUrl = applicationProperties.getUrl();
    }
    @Cacheable("holidays")
    public List<HolidayEntity> getHolidays(int year, String countryCode){
        String url = String.format("%s/%d/%s",apiUrl,year,countryCode);
        try {
            ResponseEntity<HolidayEntity[]> response = restTemplate.getForEntity(url, HolidayEntity[].class);
            if (response.getStatusCode() == HttpStatus.OK){
                HolidayEntity[] holidays = response.getBody();
                if (holidays != null){
                    return Arrays.asList(holidays);
                }
            }
            throw new RuntimeException("Unable to get list of holidays, response status: " + response.getStatusCode());
        } catch (HttpClientErrorException e){
            throw new RuntimeException("Error with fetching data from API, message: " + e.getMessage(),e);
        }
        catch (Exception e){
            throw new RuntimeException("Unexpected exception: " + e.getMessage());
        }
        return Collections.emptyList();
    }

}
