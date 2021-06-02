package com.orgfree.valdoneves.springwebmvc.controller;

import com.orgfree.valdoneves.springwebmvc.controller.request.SoldadoEditRequest;
import com.orgfree.valdoneves.springwebmvc.dto.Soldado;
import com.orgfree.valdoneves.springwebmvc.service.SoldadoService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    @Autowired
    private SoldadoService soldadoService;

    @GetMapping("/{cpf}")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable String cpf) {
        Soldado soldado = soldadoService.buscarSoldado(cpf);
//        return ResponseEntity.ok(soldado);
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editarSoldado(@PathVariable String cpf, @RequestBody SoldadoEditRequest soldadoEditRequest) {
        soldadoService.alterarSoldado(cpf, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarSoldado(@PathVariable String cpf){

        soldadoService.deletarSoldado(cpf);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Soldado>> buscarSoldado(){
        List<Soldado> soldados = soldadoService.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldados);
    }


}
