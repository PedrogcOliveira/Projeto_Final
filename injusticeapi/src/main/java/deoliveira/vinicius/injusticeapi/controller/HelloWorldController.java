package deoliveira.vinicius.injusticeapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Vinícius de Oliveira
 * @Version 1.0
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloWorldController {

//        @GetMapping("/")
//        public String index() {
//            return "Server iniciado.";
//        }

    @RequestMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<String>("Servidor inicializado.", new HttpHeaders(), HttpStatus.OK);
    }

}
