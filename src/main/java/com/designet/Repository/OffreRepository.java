package com.designet.Repository;





import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.designet.entities.Offre;
import com.designet.entitiesDTO.OffreDto;
@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>{
	@Query(value="SELECT * from offre o WHERE o.etat=0 ",nativeQuery = true)	
	List<Offre> findOffreAccept();
	List<Offre>findByEntrepriseId(Long id_e);
	List<Offre> findByEtat(Boolean etat);
	
}
