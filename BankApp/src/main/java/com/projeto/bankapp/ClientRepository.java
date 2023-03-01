package com.projeto.bankapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Cliententity, Integer> {



    Cliententity findEntityByNifAndPassword(int nif, String password);

}
