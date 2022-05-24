package edu.utfpr.rotamosquito.controller;

import edu.utfpr.rotamosquito.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/dados")
public class DadosController {

    private DadosService dadosService;

    @Autowired
    public DadosController(DadosService dadosService) {
        this.dadosService = dadosService;
    }

    @ResponseBody
    @PostMapping
    public void carregarArquivoXlsx(@RequestParam("file") MultipartFile arquivo) {
        dadosService.carregarArquivo(arquivo);
    }

}
