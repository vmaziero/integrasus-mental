package br.com.integrasus.notification.consumer;

import br.com.integrasus.notification.event.VagaReabertaEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class VagaReabertaConsumer {

    @RabbitListener(queues = "vaga.reaberta.queue")
    public void consumir(VagaReabertaEvent event) {

        System.out.println("=== NOVA VAGA REABERTA ===");
        System.out.println("Vaga ID: " + event.vagaId());
        System.out.println("Agendamento cancelado: " + event.agendamentoId());
        System.out.println("Data/Hora: " + event.dataHora());
        System.out.println("Modalidade: " + event.modalidade());
        System.out.println("Abordagem: " + event.abordagemClinica());
        System.out.println("Notificação simulada enviada.");
    }
}