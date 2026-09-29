package br.com.integrasus.scheduling.event;

import br.com.integrasus.scheduling.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VagaEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publicarVagaReaberta(
            VagaReabertaEvent event
    ) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.VAGA_EXCHANGE,
                RabbitMQConfig.VAGA_REABERTA_ROUTING_KEY,
                event
        );
    }
}