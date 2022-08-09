package com.springboot.revisao.meuobjeto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="api/v1/meuobjeto")
public class MeuObjetoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MeuObjetoController.class);
	
	final MeuObjetoService service;
	
	@Autowired
	public MeuObjetoController(MeuObjetoService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<MeuObjeto> getMeuObjetos() {
		LOG.info("Lista MeuObjetos");
		return service.getMeuObjetos();

	}
	
	@PostMapping
	public void registerMeuObjeto(@RequestBody MeuObjeto meuObjeto) {
		LOG.info("Inserindo meuObjeto");
		service.addMeuObjeto(meuObjeto);
	}
	
	@DeleteMapping(path = "{meuObjetoId}")
	public void deleteMeuObjeto(@PathVariable("meuObjetoId") Long meuObjetoId){
		LOG.info("Removendo meuObjeto com id ".concat(meuObjetoId.toString()));
		service.deleteMeuObjetoById(meuObjetoId);
	}	
	
	
	@PutMapping(path="{meuObjetoId}")
	public void updateMeuObjeto(
			@PathVariable("meuObjetoId") Long meuObjetoId,
			@RequestParam(required=false) String nome,
			@RequestParam(required=false) Integer numero
	) {
		LOG.info("Atualizando meuObjeto com id ".concat(meuObjetoId.toString()));
		service.updateMeuObjeto(meuObjetoId,nome,numero);

	}

}
