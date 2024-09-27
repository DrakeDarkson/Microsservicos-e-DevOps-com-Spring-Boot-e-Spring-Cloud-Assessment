package al.infnet.edu.br.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
}
