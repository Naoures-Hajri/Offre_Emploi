package com.designet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.designet.entities.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	boolean existsByEmail(String email);
	Admin findAdminByEmail(String email);

}
