package platform.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {
    @JsonIgnore
    private Long id;
    private String code;
    private String date;
    @JsonIgnore
    private LocalDateTime localDateTime;
}
