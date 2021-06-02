package com.orgfree.valdoneves.springwebmvc.service;

import com.orgfree.valdoneves.springwebmvc.controller.request.SoldadoEditRequest;
import com.orgfree.valdoneves.springwebmvc.dto.Soldado;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class SoldadoService {

    public Soldado buscarSoldado(String cpf){
        Soldado soldado = new Soldado();
        soldado.setCpf(cpf);
        soldado.setNome("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e Flexa");

        return soldado;
    }

    public void criarSoldado(Soldado soldado){

    }

    public void alterarSoldado(String cpf, SoldadoEditRequest soldadoEditRequest) {
    }

    public void deletarSoldado(String cpf) {
    }

    public List<Soldado> buscarSoldados(){
        Soldado soldado = new Soldado();
        soldado.setCpf("123456");
        soldado.setNome("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e Flexa");
        Soldado soldado2 = new Soldado();
        soldado2.setCpf("789123");
        soldado2.setNome("Froudo");
        soldado2.setRaca("Elfo");
        soldado2.setArma("Arco e Flexa");

        return Arrays.asList(soldado, soldado2);

    }
}
