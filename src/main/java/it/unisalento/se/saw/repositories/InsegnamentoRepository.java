package it.unisalento.se.saw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.se.saw.domain.Insegnamento;

@Repository
public interface InsegnamentoRepository extends JpaRepository<Insegnamento, Integer> {
	
	@Query("select i from Insegnamento i where i.corsoDiStudio.idcorsoDiStudio=:idCorsoDiStudio")
	public List<Insegnamento> getInsegnamentiByIdCorsoDiStudio (@Param("idCorsoDiStudio") int idCorsoDiStudio);

}
