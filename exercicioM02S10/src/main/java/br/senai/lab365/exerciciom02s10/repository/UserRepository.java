package br.senai.lab365.exerciciom02s10.repository;

import br.senai.lab365.exerciciom02s10.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
