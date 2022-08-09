package com.springboot.revisao.meuobjeto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeuObjetoRepository extends JpaRepository<MeuObjeto,Long> {

	@Query("SELECT m FROM MeuObjeto m WHERE m.numero = ?1")
	Optional<MeuObjeto> findMeuObjetoByNumero(Integer numero);
	
	
}
