package br.senac.tads.dsw.exemplosspringmvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/ex03")
    public ModelAndView exemplo03() {

        ModelAndView mv = new ModelAndView("template03");

        List<String> valores = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            valores.add("Item " + i);
        }

        boolean mostrarMensagem = true;

        mv.addObject("lista", valores);
        mv.addObject("flagMensagem", mostrarMensagem);

        return mv;
    }

    @GetMapping("/ex04")
    public ModelAndView exemplo04SomaDoisNumeros(@RequestParam("n1") int n1, @RequestParam("n2") int n2) {

        ModelAndView mv = new ModelAndView("template04");
        mv.addObject("resultado", n1 + n2);

        return mv;
    }

    @GetMapping("/ex04b")
    public ModelAndView exemplo04SomaDoisNumerosComForm(@RequestParam(value = "n1", defaultValue = "0") int n1, 
                                                        @RequestParam(value = "n2", defaultValue = "0") int n2) {

        ModelAndView mv = new ModelAndView("template04b");
        mv.addObject("resultado", n1 + n2);

        return mv;
    }

    @GetMapping("/ex05")
    public ModelAndView exemplo05(String nome, String dataNascimento, String email, String senha) {

        ModelAndView mv = new ModelAndView("template05");

        mv.addObject("nome", nome);
        mv.addObject("dataNascimento", dataNascimento);
        mv.addObject("email", email);
        mv.addObject("senha", senha);

        return mv;
    }

    @GetMapping("/ex06")
    public ModelAndView exemplo06(@RequestParam String nome, 
                                    @RequestParam String dataNascimento,
                                    @RequestParam String email,
                                    @RequestParam String senha) {

        DadosPessoais dadosPessoais = new DadosPessoais(nome, dataNascimento, email, senha);
        ModelAndView mv = new ModelAndView("template06");

        mv.addObject("dadosPessoais", dadosPessoais);

        return mv;
    }

    @GetMapping("/ex07")
    public ModelAndView exemplo07() {

        List<DadosPessoais> lista = new ArrayList<>();

        DadosPessoais d1 = new DadosPessoais("Felype", "2000-07-03", "teste@teste.com", "1234");
        DadosPessoais d2 = new DadosPessoais("Matheus", "2000-12-10", "teste@teste.com", "1234");
        DadosPessoais d3 = new DadosPessoais("Henrique", "1989-06-22", "teste@teste.com", "1234");

        lista.add(d1);
        lista.add(d2);
        lista.add(d3);

        ModelAndView mv = new ModelAndView("template07");

        mv.addObject("lista", lista);

        return mv;
    }

    @GetMapping("/ex08")
    public ModelAndView exemplo08(String apelido) {
        DadosPessoais dadosPessoais = null;

        if("Felype".equals(apelido)) {
            dadosPessoais = new DadosPessoais("Felype", "2000-07-03", "teste@teste.com", "1234");
        } else if ("Matheus".equals(apelido)) {
            dadosPessoais = new DadosPessoais("Matheus", "2000-12-10", "teste@teste.com", "1234");
        } else if ("Henrique".equals(apelido)) {
            dadosPessoais = new DadosPessoais("Henrique", "1989-06-22", "teste@teste.com", "1234");
        }

        ModelAndView mv = new ModelAndView("template08");

        mv.addObject("dadosPessoais", dadosPessoais);

        return mv;
    }

    @GetMapping("/ex08/{apelido}")
    public ModelAndView exemplo08Apelido(@PathVariable String apelido) {
        DadosPessoais dadosPessoais = null;;

        if("Felype".equals(apelido)) {
            dadosPessoais = new DadosPessoais("Felype", "2000-07-03", "teste@teste.com", "1234");
        } else if ("Matheus".equals(apelido)) {
            dadosPessoais = new DadosPessoais("Matheus", "2000-12-10", "teste@teste.com", "1234");
        } else if ("Henrique".equals(apelido)) {
            dadosPessoais = new DadosPessoais("Henrique", "1989-06-22", "teste@teste.com", "1234");
        }

        ModelAndView mv = new ModelAndView("template08");

        mv.addObject("dadosPessoais", dadosPessoais);

        return mv;
    }

    @GetMapping("/ex09")
    public ModelAndView exemplo09(@RequestHeader("user-agent") String userAgent) {

        ModelAndView mv = new ModelAndView("template09");

        mv.addObject("ua", userAgent);

        return mv;
    }

    @GetMapping("/ex10")
    public ModelAndView exemplo10(@RequestHeader("user-agent") String userAgent) {

        boolean mobile = userAgent.toLowerCase().contains("mobile");

        String templateName;

        if (mobile) {
            templateName = "template10-mobile";
        } else {
            templateName = "template10-desktop";
        }

        ModelAndView mv = new ModelAndView(templateName);

        mv.addObject("ua", userAgent);

        return mv;
    }

    @GetMapping("/ex11")
    public ModelAndView exemplo11(@RequestHeader("user-agent") String userAgent) {

        boolean mobile = userAgent.toLowerCase().contains("mobile");

        if (mobile) {
            return "redirect:/ex11-mobile";
        } else {
            return "redirect:/ex11-mobile";
        }
    }

    @GetMapping("/ex11-mobile")
    public ModelAndView exemplo11Mobile(@RequestHeader("user-agent") String userAgent) {

        ModelAndView mv = new ModelAndView("template10-mobile");

        mv.addObject("ua", userAgent);

        return mv;
    }

    @GetMapping("/ex11-desktop")
    public ModelAndView exemplo11Desktop(@RequestHeader("user-agent") String userAgent) {

        ModelAndView mv = new ModelAndView("template10-desktop");

        mv.addObject("ua", userAgent);

        return mv;
    }

    @GetMapping("/ex12")
    public ModelAndView exemplo12(@RequestHeader Map<String, String> cabecalhos) {

        ModelAndView mv = new ModelAndView("template12");

        mv.addObject("cabecalhos", cabecalhos);

        return mv;
    }
}
