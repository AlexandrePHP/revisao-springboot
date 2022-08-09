package com.springboot.revisao.meuobjeto;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeuObjetoService {
	
	private final MeuObjetoRepository meuObjetoRepository;
	
	
	@Autowired
	public MeuObjetoService(MeuObjetoRepository meuObjetoRepository) {
		this.meuObjetoRepository = meuObjetoRepository;
	}


	public List<MeuObjeto> getMeuObjetos() {
		return	this.meuObjetoRepository.findAll();
	}
	
	public boolean saveMeuObjeto(MeuObjeto meuObjeto) {
		boolean retorno=true;
		try {
			this.meuObjetoRepository.save(meuObjeto);
		} catch(Exception e) {
			e.printStackTrace();
			retorno=false;
		}
		return retorno;
	}


	public void addMeuObjeto(MeuObjeto meuObjeto) {
		System.out.println(meuObjeto);
		
		boolean saved=false; 

		Optional<MeuObjeto> meuObjetoOptional = this.meuObjetoRepository.findMeuObjetoByNumero(meuObjeto.getNumero());
		
		if(meuObjetoOptional.isPresent()) {
			throw new IllegalStateException("Já existe um registro com o número informado!");
		}

		saved = saveMeuObjeto(meuObjeto);
		
		if(!saved) {
			System.out.println("Não foi possível salvar entidade");
		}
		
		
	}


	public void deleteMeuObjetoById(Long meuObjetoId) {
		
		boolean exists = meuObjetoRepository.existsById(meuObjetoId);
		
		if(!exists) {
			throw new IllegalStateException("Não existe meuObjeto com o id ".concat(meuObjetoId.toString()));
		}
		
		meuObjetoRepository.deleteById(meuObjetoId);
		
	}


	@Transactional
	public void updateMeuObjeto(Long meuObjetoId, String nome, Integer numero) {
		
		MeuObjeto meuObjeto = meuObjetoRepository.findById(meuObjetoId).orElseThrow(
				() -> new IllegalStateException("Não existe meuObjeto com o id ".concat(meuObjetoId.toString()))
			);
		
		// verifica se é nome válido
		if(nome != null &&
				nome.length() > 0 &&
				!meuObjeto.getNome().equals(nome)
		  ) {
			meuObjeto.setNome(nome);
		}
		
		//verifica se é um número válido e q não está sendo usado ainda
		if( numero != null &&
				!meuObjeto.getNumero().equals(numero)	
		  ) {
			
			Optional<MeuObjeto> meuObjetoOptional = this.meuObjetoRepository.findMeuObjetoByNumero(numero);
			
			if(meuObjetoOptional.isPresent()) {
				throw new IllegalStateException("O número ".concat(numero.toString()).concat(" está sendo utilizado por outro objeto."));
			}
			
			meuObjeto.setNumero(numero);
			
			// OBS: A anotação @Transactional desse método o torna "managed",
			// isso quer dizer que as alterações feitas usando setters serão persistidas
		}

	}
	
}
