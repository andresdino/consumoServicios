package com.brandon.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {



    private final RestTemplate restTemplate;

    @Autowired
    public Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




    @GetMapping("/test")
    public Object getApi() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        Result result = restTemplate.getForObject(url, Result.class);
        System.out.println("Result " + result);
        return result;
    }

    @GetMapping("/test/list")
    public List<Result> getListResult() {
        String url = "https://jsonplaceholder.typicode.com/todos";
        Result[] results = restTemplate.getForObject(url, Result[].class);
        return Arrays.asList(results);

    }

    @PostMapping("/credi")
    public List<Cuentas> postApi(){
        // URL del servicio REST
        String url = "http://sesb2303ax.bancocredicoop.coop/consulta-cuentas-arco/cuentas/arco";

        // Cuerpo de la solicitud en formato JSON
        String requestBody = "{\"canal\":\"BPI\", \"idCuenta\":\"20010203488\", \"secuencia\":\"00000001\"}";

        // Configuración de encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la entidad de solicitud
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Crear RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Realizar la solicitud POST
        ResponseEntity<Cuentas> responseEntity = restTemplate.postForEntity(url, requestEntity, Cuentas.class);

        // Obtener la respuesta
        Cuentas cuentasArray = responseEntity.getBody();

        return Arrays.asList(cuentasArray);

    }


    @PostMapping("/token")
    public List<Token> token(){
        // URL del servicio REST
        String url = "http://sesb2303ax/consulta-legajo-digital/authenticate";

        // Cuerpo de la solicitud en formato JSON
        String requestBody = "{\"username\":\"escritura\", \"password\":\"1234\"}";

        // Configuración de encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la entidad de solicitud
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Crear RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Realizar la solicitud POST
        ResponseEntity<Token> responseEntity = restTemplate.postForEntity(url, requestEntity, Token.class);

        // Obtener la respuesta
        Token tokenArray = responseEntity.getBody();

        return Arrays.asList(tokenArray);

    }




}
