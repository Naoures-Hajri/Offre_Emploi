package com.designet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.designet.entities.Formateur;
@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
	boolean existsByEmail(String email);
	Formateur findFormateurByEmail(String email);
}
