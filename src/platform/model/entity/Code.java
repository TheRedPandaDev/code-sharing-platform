package platform.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {
    @JsonIgnore
    @Id
    private String id;
    private String code;
    @Transient
    @Getter(AccessLevel.NONE)
    private String date;
    @JsonIgnore
    private LocalDateTime localDateTime;
    private long time;
    private long views;
    @Transient
    @JsonIgnore
    private boolean viewsLimited;

    public String getDate() {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(localDateTime);
    }
}
