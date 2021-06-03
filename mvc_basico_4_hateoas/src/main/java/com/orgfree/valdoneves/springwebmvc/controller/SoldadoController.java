package com.orgfree.valdoneves.springwebmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orgfree.valdoneves.springwebmvc.controller.request.SoldadoEditRequest;
import com.orgfree.valdoneves.springwebmvc.controller.response.SoldadoResponse;
import com.orgfree.valdoneves.springwebmvc.dto.Soldado;
import com.orgfree.valdoneves.springwebmvc.service.SoldadoService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {


    private SoldadoService soldadoService;
    private ObjectMapper objectMapper;

    public SoldadoController(SoldadoService soldadoService, ObjectMapper objectMapper){
        this.soldadoService = soldadoService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable() Long id) {
        SoldadoResponse soldadoResponse = soldadoService.buscarSoldado(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldadoResponse);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity editarSoldado(@PathVariable Long id, @RequestBody SoldadoEditRequest soldadoEditRequest) {
        soldadoService.alterarSoldado(id, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSoldado(@PathVariable Long id) {

        soldadoService.deletarSoldado(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SoldadoResponse>> buscarSoldado() {
        List<SoldadoResponse> soldados = soldadoService.buscarSoldados().stream()
                .map(it -> objectMapper.convertValue(it, SoldadoResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(soldados);
    }


}
