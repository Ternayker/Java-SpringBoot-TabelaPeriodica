package com.tabela.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tabela.model.Pages;
import com.tabela.repository.PeriodicaPagesRepository;
import com.tabela.service.PeriodicaPagesService;

public class PeriodicaPagesImplement implements PeriodicaPagesService{

	@Autowired
	PeriodicaPagesRepository periodicaRepository;
	
	@Override
	public List<Pages> fidAll() {
		return periodicaRepository.findAll();
	}

	@Override
	public Pages findById(long id) {
		return periodicaRepository.findById(id).get();
	}

	@Override
	public Pages save(Pages page) {
		return periodicaRepository.save(page);
	}


}
