package com.example.desafiopicpay.service;

import com.example.desafiopicpay.domain.User;
import com.example.desafiopicpay.exceptions.errors.NoficiationException;
import com.example.desafiopicpay.request.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.example.desafiopicpay.enums.errorsMessage.NotificationExceptionMessage.SERVICE_NOT_FOUND;

@Service
@AllArgsConstructor
public class NotificationService {

    private RestTemplate template;

    private void sendNotification(User user,String message){
        String email = user.getEmail();

        NotificationRequest notificationRequest = new NotificationRequest(email, message);

        ResponseEntity<String> notificationResponse = template.postForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6",
                notificationRequest, String.class);

        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            throw new NoficiationException(SERVICE_NOT_FOUND.getDescription());
        }
    }
}
