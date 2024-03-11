package com.brandon.resttemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaARCO {

  
    private String nroCuenta;
    private String sucursal;
    private String fechaAlta;
    private String fechaBaja;
    private String estado;
    private String motivoCierre;
    private String formaOperar;


}