package com.minascafe.api.controllers;

import com.minascafe.api.entities.CafeBeneficiado;
import com.minascafe.api.record.DadosAtualizacaoCafeBeneficiado;
import com.minascafe.api.record.DadosCadastroCafeBeneficiado;
import com.minascafe.api.record.DadosListagemCafeBeneficiado;
import com.minascafe.api.repositories.CafeBeneficiadoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController // Endpoint (página web) de Controller
@RequestMapping("cafebeneficiado") // Define a url da classe
// @CrossOrigin(origins = "*", methods = { RequestMethod.GET,
// RequestMethod.POST, RequestMethod.PUT })
public class CafeBeneficiadoController {

    public static final Logger log = LoggerFactory.getLogger(CafeBeneficiadoController.class);

    @Autowired
    private CafeBeneficiadoRepository cafeBeneficiadoRepository; // Injetando o Repository como sendo um atributo

    
    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroCafeBeneficiado cb) {
        cafeBeneficiadoRepository.save(new CafeBeneficiado(cb));

        System.out.println("Lote de café beneficiado salvo no banco com sucesso!");

        String responseMessage = "Lote de Café Beneficiado cadastrado com sucesso!";
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping // Listagem de Café Beneficiado
    @CrossOrigin
    public ResponseEntity<List<CafeBeneficiado>> listar() {
        List<CafeBeneficiado> caf = cafeBeneficiadoRepository.findAll();
        return ResponseEntity.ok().body(caf);
    }

    /*
     * @GetMapping //Listagem de Café Beneficiado ativo paginado
     * public Page<DadosListagemCafeBeneficiado>Listar(Pageable paginacao){
     * return cafeBeneficiadoRepository.findAllByAtivoTrue(paginacao).map(
     * DadosListagemCafeBeneficiado::new);
     * }
     */

    @GetMapping("/baixado") // listagem de Café Beneficiado deletado (inativo)
    @CrossOrigin
    public Page<DadosListagemCafeBeneficiado> Baixa(Pageable paginacao) {
        return cafeBeneficiadoRepository.findAllByAtivoFalse(paginacao).map(DadosListagemCafeBeneficiado::new);
    }

    @CrossOrigin
    @GetMapping("{lote}") // listagem de lotes de Café Beneficiado "ativos"
    public ResponseEntity<List<CafeBeneficiado>> encontrar(@PathVariable int lote) {// No PathVariable o parâmetro é
                                                                                    // passado diretamente no corpo da
                                                                                    // requisição e esse valor faz parte
                                                                                    // do corpo da requisição
        List<CafeBeneficiado> ben = cafeBeneficiadoRepository.findByLoteAndAtivoTrue(lote);
        return ResponseEntity.ok().body(ben);
    }

    @GetMapping("/produtor/{produtor}")
    @CrossOrigin
    public ResponseEntity<List<CafeBeneficiado>> busca_produtor(@PathVariable String produtor) {
        List<CafeBeneficiado> caf = cafeBeneficiadoRepository.findByProdutor(produtor);
        return ResponseEntity.ok().body(caf);
    }

    @PutMapping // Realiza atualizações (Update) no cadastro
    @Transactional
    @CrossOrigin
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeBeneficiado db) {
        System.out.println("Atualizando lote: "+db.lote() + ", ativo: " + db.ativo());
        var beneficiado = cafeBeneficiadoRepository.getReferenceById(db.lote());
        beneficiado.atualizarInformacoes(db);
        cafeBeneficiadoRepository.flush(); // Garante que a transação seja persistida
    }
}