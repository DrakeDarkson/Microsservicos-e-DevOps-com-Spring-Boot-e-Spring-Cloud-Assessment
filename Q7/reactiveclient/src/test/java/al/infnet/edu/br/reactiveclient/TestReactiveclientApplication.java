package al.infnet.edu.br.reactiveclient;

import org.springframework.boot.SpringApplication;

public class TestReactiveclientApplication {

	public static void main(String[] args) {
		SpringApplication.from(ReactiveclientApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
