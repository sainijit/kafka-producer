package org.redhat.kafka.producer;

import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demos/kafka/producer")
public class KafkaProducerAPI {
	
	@Value("${bootstrapServer}")
    private String bootstrapServer;
	
	@PostMapping("/putmessage")
    public String putMessage(@RequestHeader Map<String, String> headers) throws Exception {
		System.out.println("******** KafkaProducerAPI|putMessage|headers=" + headers + "|bootstrapServer="+bootstrapServer);
		Properties properties = new Properties();
        properties.put("bootstrap.servers",bootstrapServer);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("security.protocol", "SSL");
        properties.put("ssl.truststore.location", "/deployments/keystore.jks");
        properties.put("ssl.truststore.password", "password"); 
        
        headers.forEach((key, value) -> {
        	System.out.println("key="+key+",value="+value);
            properties.put(key, value);
        });
        
        //properties.put("batch.size", 30000); // 16384=default value
		//properties.put("linger.ms", 1);
		//properties.put("buffer.memory", 33554432);
		System.out.println("************ kafka Producer **********");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        String response = null;
        try{
        	
            for(long i = 1; i<=Integer.parseInt(properties.get("msgcount").toString()); i++){
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++  "+i);
                kafkaProducer.send(new ProducerRecord<String, String>("my-topic", Long.toString(i), "test message - " + i ));
                System.out.println("___________________________________________________");
            }
            response = "Message put successfully to kafka queue";
            System.out.println("***************************"+response);
        }catch (Exception e){
        	response = "Error putting message to kafka queue";
            e.printStackTrace();
    		System.out.println("******************************"+e);
        }finally {
            kafkaProducer.close();
        }
		
		return response;
    }

}
