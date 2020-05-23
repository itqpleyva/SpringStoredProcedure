# SpringStoredProcedure
Example of defining and calling a stored procedure from spring boot

Dependencies:

        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
           <groupId>org.flywaydb</groupId>
           <artifactId>flyway-core</artifactId>
           <version>5.2.4</version>
       </dependency>
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <scope>runtime</scope>
        </dependency>

First step(definig Stored procedure):

          DELIMITER $$
          CREATE PROCEDURE GET_ANIMALS(IN id INT, IN specie VARCHAR(50), IN name VARCHAR(50), IN code INT)
          BEGIN
             INSERT INTO animal values(id,specie,name,code);
          END $$
          DELIMITER;

          DELIMITER $$
          CREATE PROCEDURE GET_ANIMAL(IN code_in INT, OUT count INT)
          BEGIN
             SELECT COUNT(*) into count  from animal where code = code_in;
          END $$
          DELIMITER;
          
Second step(definig methods un repository):

            @Repository
            public interface AnimalRepository extends JpaRepository<Animal, Integer> {

              @Procedure
              public void GET_ANIMALS(Integer id, String specie, String name, Integer code);

              @Procedure
              public int GET_ANIMAL(Integer code);
            }

Third step(calling procedures):

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


                animalRepo.GET_ANIMALS(18,"Mamals","Pepe",19); //new animal inserted

                int count = animalRepo.GET_ANIMAL(18);// get the count of animals with code = 18

                System.out.println("El total es: "+count);

              }

            }
