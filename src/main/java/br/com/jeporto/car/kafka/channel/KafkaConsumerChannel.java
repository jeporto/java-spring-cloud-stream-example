package br.com.jeporto.car.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaConsumerChannel {

	String INPUT = "input";

	@Input(INPUT)
	SubscribableChannel input();

}