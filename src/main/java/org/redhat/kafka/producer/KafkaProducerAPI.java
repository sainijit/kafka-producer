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
        properties.put("ssl.truststore.certificates", "þíþí   \u0002   \u0001   \u0002 \u0004root  \u0001zSÅO´ \u0005X.509  \u000310‚\u0003-0‚\u0002\u0015 \u0003\u0002\u0001\u0002\u0002\t êWƒµ‰ä‚L0\n" +
                "\u0006\t*†H†÷\n" +
                "\u0001\u0001\u000B\u0005 0-1\u00130\u0011\u0006\u0003U\u0004\n" +
                "\f\n" +
                "io.strimzi1\u00160\u0014\u0006\u0003U\u0004\u0003\f\n" +
                "cluster-ca v00\u001E\u0017\n" +
                "210628172101Z\u0017\n" +
                "220628172101Z0-1\u00130\u0011\u0006\u0003U\u0004\n" +
                "\f\n" +
                "io.strimzi1\u00160\u0014\u0006\u0003U\u0004\u0003\f\n" +
                "cluster-ca v00‚\u0001\"0\n" +
                "\u0006\t*†H†÷\n" +
                "\u0001\u0001\u0001\u0005 \u0003‚\u0001\u000F 0‚\u0001\n" +
                "\u0002‚\u0001\u0001 ÄeŠ«Tawku>í\u0004\u001CäK]fní<8–¾N‹(öíBÛj%\\\n" +
                "\u0006ÅªýÊ\t²\u008DÛõ»–f×îGkùÕ?ê12%£\u0015Ü,7µV\u0006>c¨zVjûH›\u0014Ð0º4\u00115½å|ˆ3Îl:„\u0016J[6ð\u0003S\u00022Ù#ŽÒÁV¡\fœW‚¹\u001CJ0\u001Cì\u0012Þ\u0081¢\\®ù±S îðì±Å\u000B¤ªÜ›ûÈÅ\u0090‰\u001C\u0017w6*¡=‚µÁp'\u008DªA¤À%€E¤,Wš#\n" +
                "E|d¾\u0016\u0006\u0002[q¯\t˜Ü½Côn¯zÛ\\6\u0004\u0001\u000E@l&oO˜Ìs\u0015;\u0011¾\"™Ù/AËTü¼Ij\n" +
                "-\u0010\u0006\fétVR²ìËm‹zÂ\u007F¸`(Ò &ù’J^•!Å\u001D}wQøx1×Å)\u0002\u0003\u0001 \u0001£P0N0\u001D\u0006\u0003U\u001D\u000E\u0004\u0016\u0004\u0014\bþe¿Pl&h”\u000Bÿ\u0014U¯Ê\u000Fpy]f0\u001F\u0006\u0003U\u001D#\u0004\u00180\u0016€\u0014\bþe¿Pl&h”\u000Bÿ\u0014U¯Ê\u000Fpy]f0\f\u0006\u0003U\u001D\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\n" +
                "\u0006\t*†H†÷\n" +
                "\u0001\u0001\u000B\u0005 \u0003‚\u0001\u0001 9\n" +
                "úLÛv;â×:”y¹ÛóÎnS\n" +
                "NKà[$\u000BÐ_Ó\u007F\u001CÎŠ\u008DúË4H«É\u009DdŒ“Ä\b\u0012Ò4…†l\u00AD—°\"\u0018W\u001DÊ¢rm@·ôøR¦xülÉ\u0013ÿ\u0003v=¥h)3Àýh[€çßºu\n" +
                "\u0002_ïÁ\u0004‡&{uÝÿÓø`Š–m[ûo{Ïgª½²7Ö™ë\u007F_ø›ÎQàMo=Ó\"Ø‹=èhÊ¦\u007Fv´ˆ¿:ÚüšŸ\n" +
                "{Ü)ƒ\u008DË39wO˜Ò2–´ð°9\u0090¥¶wJà/¸qaNÉï\u0013M:‘W*ªëšÔp$%õÈ\u000Bñk–€w/©4\u001B1\u009D\u0019#©\u0012î=E\u0081Óº{°€\u000Fþ\fE¤òñß8t{:,)B´qöJ¡\u0003éCU!Ù˜(Ùi\u0010z=\u0011îÊ±Êç\"ìýKcnãiY;dŠSz7");
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
