package com.dschallenge.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dschallenge.crud.dto.ClientDTO;
import com.dschallenge.crud.entities.Client;
import com.dschallenge.crud.repositories.ClientRepository;
import com.dschallenge.crud.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
	
		List<Client> list = new ArrayList<Client>();
		list = clientRepository.findAll();
		
		List<ClientDTO> listDTO = list.stream().map( 
				x -> new ClientDTO(x))
				.collect(Collectors.toList());
				
		/*
		List<ClientDTO> listDTO = new ArrayList<ClientDTO>();
		
		for( Client entity : list) {
			listDTO.add(new ClientDTO(entity)); // ClientDTO dto = new ClientDTO(entity); listDTO.add(dto);
		}
		*/
		return listDTO;
	}
	
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new ClientDTO(entity);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
