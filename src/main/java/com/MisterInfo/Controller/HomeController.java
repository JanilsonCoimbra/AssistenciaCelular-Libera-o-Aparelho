package com.MisterInfo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MisterInfo.Model.Aparelhos;
import com.MisterInfo.Repository.AparelhosRepository;

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
	public String consultaOS(HttpServletRequest request, @PathVariable int os) {
			List<Aparelhos> ap = APConsulta.findAll();
			Aparelhos selecao = new Aparelhos();
			ap.forEach(item -> {
				if(item.getNumeroOs() == os) {
					selecao.setId(item.getId());
					selecao.setModeloAparelho(item.getModeloAparelho());
					selecao.setNumeroOs(item.getNumeroOs());
					selecao.setStatusAparelho(item.getStatusAparelho());
				}
			});
			request.setAttribute("nome", selecao.getStatusAparelho());
			return "consulta";
	}
}
