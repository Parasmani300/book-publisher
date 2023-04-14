package com.paras.mani.bookpublisher.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public ProducerFactory<String,Object> producerFactory()
    {
        Map<String,Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        props.put(ProducerConfig.ACKS_CONFIG,"all");

        String bootstrapServer = "pkc-6ojv2.us-west4.gcp.confluent.cloud:9092";
        String saslmechansim = "PLAIN";
        String jaasConfig = "org.apache.kafka.common.security.plain.PlainLoginModule required username='O2FP6ZCGYM5NVB4J' password='A9LK6mev3hEsKo/sj8zK6AdkSWnsRUs9fS8dAlkdcCtw8U0wyDqtJwQ2kgJyV71u';";
        String securityProtocol = "SASL_SSL";
        String sessionTimeout = "45000";

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        props.put(SaslConfigs.SASL_MECHANISM,saslmechansim);
        props.put(SaslConfigs.SASL_JAAS_CONFIG,jaasConfig);
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG,securityProtocol);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 30 * 1000);
        props.put(ProducerConfig.RETRIES_CONFIG, 5);
        props.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, 3000);


        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String,Object> kafkaTemplate()
    {
        return new KafkaTemplate<>(producerFactory());
    }

}
