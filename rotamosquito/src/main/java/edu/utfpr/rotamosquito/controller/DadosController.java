package edu.utfpr.rotamosquito.controller;

import edu.utfpr.rotamosquito.dto.DadosResultDTO;
import edu.utfpr.rotamosquito.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/dados")
public class DadosController {

    private final DadosService dadosService;

    @Autowired
    public DadosController(DadosService dadosService) {
        this.dadosService = dadosService;
    }

    @ResponseBody
    @PostMapping
    public void carregarArquivoXlsx(@RequestParam("file") MultipartFile arquivo) {
        dadosService.carregarArquivo(arquivo);
    }

    @ResponseBody
    @GetMapping
    public DadosResultDTO carregarDadosMapa(@RequestParam("cidade") String dsCidade) {
        return dadosService.carregarDadosMapa(dsCidade);
    }

}
