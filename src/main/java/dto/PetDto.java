package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Jacksonized
public class PetDto {
    private String name;
    private String status;
}