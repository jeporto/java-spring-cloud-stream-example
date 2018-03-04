package br.com.jeporto.car.kafka.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaProducerChannel {

	public static final String OUTPUT = "output";

	@Output(OUTPUT)
	MessageChannel output();
}
