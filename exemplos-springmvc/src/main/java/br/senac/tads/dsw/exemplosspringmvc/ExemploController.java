package br.senac.tads.dsw.exemplosspringmvc;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExemploController {
    
    @GetMapping("/ex01") // Significa: Responde método GET do HTTP para URL /ex01
    public String exemplo01() {
        return "template01"; // Significa: nome do arquivo de template que será usado para montar resposta HTTP
    }
    
    @GetMapping("/ex02")
    public String exemplo02(Model model) {
        String titulo = "Exemplo 2 - Título gerado no Controller";
        LocalDateTime dataHora = LocalDateTime.now();
        int numero = 98;
        
        model.addAttribute("tituloAttr", titulo);
        model.addAttribute("dataHoraXyz", dataHora);
        model.addAttribute("algumNumero", numero);
                
        return "template02";        
    }
    
    @GetMapping("/ex02b")
    public ModelAndView exemplo02b() {
        String titulo = "Exemplo 2B - Título gerado no Controller";
        LocalDateTime dataHora = LocalDateTime.now();
        int numero = 33;
        
        ModelAndView mv = new ModelAndView("template02");
        
        mv.addObject("tituloAttr", titulo);
        mv.addObject("dataHoraXyz", dataHora);
        mv.addObject("algumNumero", numero);
                
        return mv;        
    }
}
