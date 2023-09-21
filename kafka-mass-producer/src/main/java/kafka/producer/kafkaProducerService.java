package kafka.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class kafkaProducerService {
    @Autowired
    public KafkaTemplate<String,String> kafkaTemplate;


    public void generateMsg() throws InterruptedException {
        String topic="v-wiki-topic";
        EventHandler eh=new KafkaChangeHandler(topic);
String url="https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder=new EventSource.Builder(eh, URI.create(url));
        EventSource eventSource=builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(5);
System.out.println("kafkaProducerService exited.....");
    }

}
