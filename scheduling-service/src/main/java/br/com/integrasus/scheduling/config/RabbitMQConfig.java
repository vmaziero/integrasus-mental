package br.com.integrasus.scheduling.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String VAGA_EXCHANGE =
            "vaga.exchange";

    public static final String VAGA_REABERTA_QUEUE =
            "vaga.reaberta.queue";

    public static final String VAGA_REABERTA_ROUTING_KEY =
            "vaga.reaberta";

    @Bean
    public TopicExchange vagaExchange() {
        return new TopicExchange(VAGA_EXCHANGE);
    }

    @Bean
    public Queue vagaReabertaQueue() {
        return QueueBuilder
                .durable(VAGA_REABERTA_QUEUE)
                .build();
    }

    @Bean
    public Binding vagaReabertaBinding(
            Queue vagaReabertaQueue,
            TopicExchange vagaExchange
    ) {
        return BindingBuilder
                .bind(vagaReabertaQueue)
                .to(vagaExchange)
                .with(VAGA_REABERTA_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory,
            MessageConverter jsonMessageConverter
    ) {
        RabbitTemplate rabbitTemplate =
                new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(
                jsonMessageConverter
        );

        return rabbitTemplate;
    }
}