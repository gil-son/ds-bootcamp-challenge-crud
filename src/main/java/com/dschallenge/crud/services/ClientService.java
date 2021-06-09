package com.dschallenge.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> page = clientRepository.findAll(pageRequest);
		return page.map( x -> new ClientDTO(x));
	}
	
	
	/*
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
	
		List<Client> list = new ArrayList<Client>();
		list = clientRepository.findAll();
		
		List<ClientDTO> listDTO = list.stream().map( 
				x -> new ClientDTO(x))
				.collect(Collectors.toList());
				
		// Comment
		List<ClientDTO> listDTO = new ArrayList<ClientDTO>();
		
		for( Client entity : list) {
			listDTO.add(new ClientDTO(entity)); // ClientDTO dto = new ClientDTO(entity); listDTO.add(dto);
		}
		//End comment
		return listDTO;
	}
	*/
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new ClientDTO(entity);
	}
	
	
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName()); // Client received the value
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
		entity = clientRepository.save(entity);
		return new ClientDTO(entity); //Return DTO to show/representation values
	}
	
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = clientRepository.getOne(id);
			entity.setName(dto.getName()); // Client received the value
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity = clientRepository.save(entity);
			return new ClientDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found it: "+id);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
