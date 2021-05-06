package com.devjeronimo.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devjeronimo.dsvendas.dto.SellerDTO;
import com.devjeronimo.dsvendas.entities.Seller;
import com.devjeronimo.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repo;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repo.findAll();
		return result.stream().map(seller -> new SellerDTO(seller)).collect(Collectors.toList());
	}
}
