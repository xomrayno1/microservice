package com.app.config;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties.AckMode;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	@Value("${kafka.bootstrap.server.config}")
	private String bootstrapServerConfig;
	
//	@Autowired
//	public KafkaTemplate<String, Object> kafkaTemplate;
// 
	
	@Bean
	KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		/**
		 * Tạo ra 3 luồng chạy xong xong để đọc message
		 * */
		factory.setConcurrency(3);
		factory.getContainerProperties().setPollTimeout(3000);
		factory.getContainerProperties().setAckMode(AckMode.RECORD);
		/**
		 * Cố gắng phân phối lại event sau 1s, và cố gắng 2 lần nếu ko được thì gửi đến DTL
		 * DeadLetterPublishingRecoverer: gủi event bị lỗi đến dlt topic, topic clone từ topic hiện tại thêm .dtl 
		 * topic dlt chuyên xử lý nếu bị lỗi
		 * */
		//factory.setCommonErrorHandler(new DefaultErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate) ,new FixedBackOff(1000L, 2L)));
		return factory;
	}

	@Bean
	public ConsumerFactory<Integer, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerConfig);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group");
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//		props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
//		props.put(JsonDeserializer.TYPE_MAPPINGS, "verify:com.app.dto.VerifyMessageDTO");
		return props;
	}
 
 
}
