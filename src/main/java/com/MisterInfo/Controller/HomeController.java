package com.MisterInfo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MisterInfo.Model.Aparelhos;
import com.MisterInfo.Repository.AparelhosRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@Controller
@RequestMapping
public class HomeController {
	
	@Autowired
	AparelhosRepository APConsulta;

	@GetMapping
	public String homePage() {
		return "homePage";
	}
	
	@GetMapping("/consulta/{os}")
	public String consultaOS(HttpServletRequest request, @PathVariable float os) {
		
			List<Aparelhos> ap = APConsulta.findAll();
			Aparelhos selecao = new Aparelhos();
			ap.forEach(item -> {

				if(item.getNumeroOs() == os) {
					// Se o numero de OS for igual ao que foi passado na URL, ele pega os dados do aparelho
					// e coloca no objeto selecao
					selecao.setId(item.getId());
					selecao.setModeloAparelho(item.getModeloAparelho());
					selecao.setNumeroOs(item.getNumeroOs());
					selecao.setStatusAparelho(item.getStatusAparelho());
					
					if(item.getStatusAparelho() == true) {
						request.setAttribute("nome", item.getNumeroOs() + " Aparelho Disponivel na Loja, Modelo: " + item.getModeloAparelho());
					}else if(item.getStatusAparelho() == false) {
						request.setAttribute("nome", item.getNumeroOs() + " Aparelho "+item.getModeloAparelho()+" indisponivel, aguarde...");
					}
				}else if(selecao.getNumeroOs() == 0) {
					request.setAttribute("nome", os + " Numero de OS inválido! ");
				}

			});

			return "consulta";
	}
}
