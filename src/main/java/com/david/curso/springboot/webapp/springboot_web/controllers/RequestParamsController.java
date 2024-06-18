package com.david.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.david.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")  //Ruta general base
public class RequestParamsController {

    // Un parámetro
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam (required = false, defaultValue = "Valor por defecto") String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    };


    // Dos parámetros 
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {

        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    };

    //Utilizando httpServletRequest
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {

        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));    //bloque tryCatch para gestionar error por si code no se puede parsear a String
        } catch (NumberFormatException e) {
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
}
    


