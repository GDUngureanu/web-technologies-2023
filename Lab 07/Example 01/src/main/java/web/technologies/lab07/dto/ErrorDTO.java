package web.technologies.lab07.dto;

import lombok.Data;

@Data
public class ErrorDTO {
    
    private final int status;
    private final String type;
    private final String message;
    
}
