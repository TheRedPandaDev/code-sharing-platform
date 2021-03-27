package platform.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeDTO {
    @NotNull
    private String code;
    @NotNull
    private long time;
    @NotNull
    private long views;
}
