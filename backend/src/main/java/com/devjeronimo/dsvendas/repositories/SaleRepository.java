package com.devjeronimo.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devjeronimo.dsvendas.dto.SaleSuccessDTO;
import com.devjeronimo.dsvendas.dto.SaleSumDTO;
import com.devjeronimo.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

	// Buscas agrupado
	@Query("SELECT new com.devjeronimo.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj  GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devjeronimo.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj  GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}