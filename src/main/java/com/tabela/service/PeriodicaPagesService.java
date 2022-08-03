package com.tabela.service;

import java.util.List;

import com.tabela.model.Pages;

public interface PeriodicaPagesService {

	List<Pages> fidAll();
	Pages findById(long id);
	Pages save(Pages page);
}
