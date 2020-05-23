package Main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Main.Repositories.AnimalRepository;

@SpringBootApplication
public class Main implements CommandLineRunner{

	@Autowired
	AnimalRepository animalRepo;
	
	public static void main(String[] args) {
		
		SpringApplication.run(Main.class, args);
		System.out.println("I am in");
		
	
	}
	@Override
	public void run(String... args) throws Exception {
		
	
		animalRepo.GET_ANIMALS(18,"Mamals","Pepe",19);
		
		int count = animalRepo.GET_ANIMAL(18);
		
		System.out.println("El total es: "+count);
		
	}

}
