package com.projeto.bankapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Cliententity, Long> {



    Cliententity findEntityByNifAndPassword(long nif, String password);

}
