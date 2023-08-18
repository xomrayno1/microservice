package com.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaProducerConfig {
	@Value("${kafka.bootstrap.server.config}")
	private String bootstrapServerConfig;
	
	@Bean
	public Map<String, Object> producerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerConfig);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	    props.put(ProducerConfig.ACKS_CONFIG, "-1");
	    props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, "10");
	    props.put(ProducerConfig.RETRIES_CONFIG, "3");
	    //props.put(JsonSerializer.TYPE_MAPPINGS, "verify:com.app.request.VerifyMessageDTO");
	    return props;
	}
	
	@Bean
	public ProducerFactory<String, Object> producerFactory() {
	    return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate() {
	    return new KafkaTemplate<>(producerFactory());
	}
}
