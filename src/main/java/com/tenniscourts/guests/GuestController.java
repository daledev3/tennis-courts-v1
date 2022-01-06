package com.tenniscourts.guests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

public class GuestController {
	
	@RestController
	@RequestMapping(value="/guest")
	@Api(value="API reserva da quadra de tenis")
	@CrossOrigin(origins="*")
	public class ProdutoResource {
		
		@Autowired
		GuestRepository guestRepository;
		
		@GetMapping("guest")
		@ApiOperation(value="Retorna uma lista de convidados")
		public List<Guest> listaProdutos() {
			return guestRepository.findAll();
		}
		
		@GetMapping("/guest/{id}")
		@ApiOperation(value="Retorna um unico convidado por id")
		public Guest listaProdutoUnico(@PathVariable(value="id") long id) {
			return guestRepository.findById(id);
		}
		
		@GetMapping("/guest/{nome}")
		@ApiOperation(value="Retorna um unico convidado por nome")
		public Guest listaProdutoUnico(@PathVariable(value="nome") String nome) {
			return guestRepository.findByNome(nome);
		}
		
		@PostMapping("/guest")
		@ApiOperation(value="Salva um convidado")
		public Guest salvaProduto(@RequestBody Guest guest) {
			return guestRepository.save(guest);
		}
		
		@DeleteMapping("/guest")
		@ApiOperation(value="Deleta um convidado")
		public void deletaProduto(@RequestBody Guest guest) {
			guestRepository.delete(guest);
		}
		
		@PutMapping("/guest")
		@ApiOperation(value="Atualiza um produto")
		public Guest atualizaProduto(@RequestBody Guest guest) {
			return guestRepository.save(guest);
		}
	}
}

