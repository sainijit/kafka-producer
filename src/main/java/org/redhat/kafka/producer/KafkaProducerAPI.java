package org.redhat.kafka.producer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonToken;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demos/kafka/producer")
public class KafkaProducerAPI {
	
	@Value("${bootstrapServer}")
    private String bootstrapServer;

    @Autowired
    ResourceLoader resourceLoader;
	
	@PostMapping("/putmessage")
    public String putMessage(@RequestHeader Map<String, String> headers) throws Exception {
		System.out.println("******** KafkaProducerAPI|putMessage|headers=" + headers + "|bootstrapServer="+bootstrapServer);

        System.out.println("code is updated");
		Properties properties = new Properties();
        properties.put("bootstrap.servers",bootstrapServer);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       // properties.put("security.protocol", "SSL");
//        Collection<Path> paths = find("keystore.jks","/");
//        for(Path path: paths){
//            System.out.println("path:"+path.toString());
//        }
//        try{
//            File file = new File("/deployments/kafka-producer-ocp-0.0.1-SNAPSHOT.jar/BOOT-INF/classes/keystore.jks");
//            BufferedReader br = new BufferedReader(new FileReader(file));
//
//            String st;
//            while ((st = br.readLine()) != null)
//                System.out.println(st);
//        }catch (FileNotFoundException e){
//            System.out.println("line 48");
//            File file = new File("/BOOT-INF/classes/keystore.jks");
//            BufferedReader br = new BufferedReader(new FileReader(file));
//
//            String st;
//            while ((st = br.readLine()) != null)
//                System.out.println(st);
//        }
//        Resource resource = resourceLoader.getResource("classpath:keystore.jks");
//        InputStream input = resource.getInputStream();
//
//        File file = resource.getFile();
//        System.out.println(file.getAbsolutePath());

//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource[] resources = resolver.getResources("classpath*:keystore.jks");
//
//        if(resources != null){
//            for(Resource r: resources) {
//                if(r == null)
//                    continue;
//                if(r.getFilename().contains("store")){
//                    InputStream inputStream = r.getInputStream();
//                    File somethingFile = File.createTempFile(r.getFilename(), ".jks");
//
//                    System.out.println("File Path is " + somethingFile.getAbsolutePath());
//                }
//            }
//        }
        //properties.put("ssl.truststore.location", "/deployments/BOOT-INF/classes/keystore.jks");
        //properties.put("ssl.truststore.password", "password");
        
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

    protected static Collection<Path> find(String fileName, String searchDirectory) throws IOException {
//        try (Stream<Path> files = Files.walk(Paths.get(searchDirectory))) {
//            return files
//                    .filter(f -> f.getFileName().toString().equals(fileName))
//                    .collect(Collectors.toList());
//
//        }
        return null;
    }

}
