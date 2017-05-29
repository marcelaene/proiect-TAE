package app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
public class Job {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
    @Getter @Setter private Long idJob; 
	
	@Getter @Setter private String denumireJob;
	@Getter @Setter private String denumireFirma;	
	@Getter @Setter private String descriereJob;	
	@Getter @Setter private String domeniu;	
	@Getter @Setter private String oras;	
	@Getter @Setter private String nivelCariera;		
	@Getter @Setter private String urlPoza;
}
