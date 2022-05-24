package edu.utfpr.rotamosquito.service;

import edu.utfpr.rotamosquito.orm.Dados;
import edu.utfpr.rotamosquito.repository.DadosRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class DadosService {

    private final DadosRepository dadosRepository;

    @Autowired
    public DadosService(DadosRepository dadosRepository) {
        this.dadosRepository = dadosRepository;
    }

    public void carregarArquivo(MultipartFile multipartFile) {

        try {
            final XSSFWorkbook wb = new XSSFWorkbook(multipartFile.getInputStream());
            final int totalSheets = wb.getNumberOfSheets();
            for (int i = 0; i < totalSheets; i++) {
                XSSFSheet sheet = wb.getSheetAt(i);
                sheet.removeRow(sheet.getRow(0));
                loadSheet(sheet);
            }

            wb.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //--

    private void loadSheet(XSSFSheet sheet){

        for (Row row : sheet) {
            final LocalDate data = loadDate(row.getCell(0));
            final String endereco = loadString(row.getCell(4));
            final String situacao = loadString(row.getCell(5));

            if (data != null && situacao != null){
                final Dados dados = new Dados(data, endereco, situacao);
                dadosRepository.save(dados);
            }
        }
    }

    private String loadString(Cell cell){

        if (cell == null){
            return null;
        }if (cell.getCellType().equals(CellType.NUMERIC)){
            return String.valueOf(cell.getNumericCellValue());
        }

        return cell.getStringCellValue();
    }

    private LocalDate loadDate(Cell cell){

        if (cell == null){
            return null;
        }

        try {
            Date date = null;
            if (cell.getCellType().equals(CellType.STRING)){
                System.out.println(cell.getStringCellValue());
            }else {
                date = cell.getDateCellValue();
            }
            return date == null? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
