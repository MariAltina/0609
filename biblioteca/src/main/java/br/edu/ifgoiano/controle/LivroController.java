package br.edu.ifgoiano.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifgoiano.entidade.Livro;
import br.edu.ifgoiano.servico.LivroService;
import br.edu.ifgoiano.servico.LivroServiceImpl;

@Controller
public class LivroController {
	private final LivroService livroServiceImpl;

	public LivroController(LivroServiceImpl livroServiceImpl) {
		this.livroServiceImpl = livroServiceImpl;
	}

	@GetMapping("/livro")
	public String listarlivros(Model model) {
		model.addAttribute("livro", livroServiceImpl.listarLivros());
		return "listar-livro";
	}
	@GetMapping("/livro/novo")
	public String abrirNovoLivro(Model model) {
		Livro livro = new Livro();
		
		model.addAttribute("livro", livro);
		
		return "inserir-livro";
		
	}
	@PostMapping("/livro/inserir")
	public String inserirLivros(Livro livro) {
		this.livroServiceImpl.inserir(livro);
		
		return "redirect:/livro";
	}
}
