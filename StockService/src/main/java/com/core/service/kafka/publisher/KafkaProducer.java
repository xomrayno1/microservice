package com.core.service.kafka.publisher;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.support.SendResult;

public interface KafkaProducer<K , V  > {
	void send(String topicName, K key, V message, CompletableFuture<SendResult<K, V>> callback);
}
