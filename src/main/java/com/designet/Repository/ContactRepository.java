package com.designet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.designet.entities.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
