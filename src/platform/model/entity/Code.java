package platform.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {
    @JsonIgnore
    @Id
    private String id;
    private String code;
    private String date;
    @JsonIgnore
    private LocalDateTime localDateTime;
    private long time;
    private long views;
    @Transient
    @JsonIgnore
    private boolean viewsLimited;
}
