package al.infnet.edu.br.reactiveserver.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("produto")
public class Produto {

    @Id
    private Long id;
    private String nome;
    private Double preco;
}
