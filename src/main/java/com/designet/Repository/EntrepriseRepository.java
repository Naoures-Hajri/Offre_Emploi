package com.designet.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.designet.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>  {
	boolean existsByEmail(String email);
	Entreprise findEntrepriseByEmail(String email);
	Optional<Entreprise> getEntrepriseById(Long entrepriseId);

}
