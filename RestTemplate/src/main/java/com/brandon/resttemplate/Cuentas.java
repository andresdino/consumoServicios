package com.brandon.resttemplate;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuentas {

    //@JsonProperty("mensaje")
    private String mensaje;

    ///@JsonProperty("consCuentasARCO")
    private List<CuentaARCO> consCuentasARCO;

   // @JsonProperty("secuencia")
    private String secuencia;


}
