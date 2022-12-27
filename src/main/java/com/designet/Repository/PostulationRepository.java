package com.designet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.designet.entities.Postulation;


@Repository
public interface PostulationRepository extends JpaRepository<Postulation, Long> {
	List<Postulation>findByFormateurId(Long id);
	List<Postulation>findByOffreId(Long id);
	Boolean existsByFormateurIdAndOffreId(Long idF,Long idO);

}
