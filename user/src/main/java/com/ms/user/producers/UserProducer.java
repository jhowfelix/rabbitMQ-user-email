package com.ms.user.producers;


import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    // Instancia do rabbitTemplate
     final RabbitTemplate rabbitTemplate;

     public UserProducer(RabbitTemplate rabbitTemplate){
         this.rabbitTemplate = rabbitTemplate;
     }

     // Basicamente a key da fila, para que possa ser feito o redirecionamento para sua respectiva fila.
     @Value(value = "${broker.queue.email.name}")
     private String routingKey;

     public void publishMessageEmail(UserModel userModel){
       var emailDto = new EmailDto();
       emailDto.setUserId(userModel.getUserId());
       emailDto.setEmailTo(userModel.getEmail());
       emailDto.setSubject("[API RabbitMQ] - Cadastro realizado com sucesso!");
       emailDto.setText(userModel.getName() + ", Parabéns por ter ser registrado!");

       rabbitTemplate.convertAndSend("", routingKey, emailDto);
     }

}
