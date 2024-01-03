package com.freddy.chat.controller;

import com.freddy.chat.model.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/mensaje")   //envia el mensaje
    @SendTo("/chat/mensaje")        //recibe el mensaje o "escucha"
    public Mensaje recibeMensaje(Mensaje mensaje) {
        mensaje.setFecha(new Date().getTime());

        if(mensaje.getTipo().equals("NUEVO_USUARIO")){
            mensaje.setTexto("Nuevo usuario");
        }

        return mensaje;
    }


}
