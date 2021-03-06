package br.com.jeporto.car.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

import br.com.jeporto.car.kafka.channel.KafkaProducerChannel;

@SpringBootApplication
@EnableAutoConfiguration
@EnableBinding(KafkaProducerChannel.class)
@ComponentScan("br.com.jeporto.car")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}