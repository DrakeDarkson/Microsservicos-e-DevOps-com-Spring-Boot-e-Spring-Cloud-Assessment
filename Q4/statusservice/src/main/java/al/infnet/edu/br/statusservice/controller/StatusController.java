package al.infnet.edu.br.statusservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    public String status() {
        return "O serviço está ativo!";
    }
}
