package Main.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import Main.Model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	@Procedure
	public void GET_ANIMALS(Integer id, String specie, String name, Integer code);
	
	@Procedure
	public int GET_ANIMAL(Integer code);
}
