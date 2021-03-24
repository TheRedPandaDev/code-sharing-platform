package platform.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String id;

    public Response(long id) {
        this.id = String.valueOf(id);
    }
}
