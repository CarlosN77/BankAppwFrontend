package com.projeto.bankapp.repositories;

import com.projeto.bankapp.entities.Cliententity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Cliententity, Long> {



    Cliententity findByNifAndPassword(Integer nif, String password);

}
