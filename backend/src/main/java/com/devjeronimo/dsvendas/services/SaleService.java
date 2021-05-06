package com.devjeronimo.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devjeronimo.dsvendas.dto.SaleDTO;
import com.devjeronimo.dsvendas.entities.Sale;
import com.devjeronimo.dsvendas.repositories.SaleRepository;
import com.devjeronimo.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepo;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	// Busca paginada
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = saleRepo.findAll(pageable);
		return result.map(seller -> new SaleDTO(seller));
	}
}
