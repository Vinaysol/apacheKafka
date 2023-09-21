package kafka.producer.config;


import com.launchdarkly.eventsource.EventHandler;
import kafka.producer.KafkaChangeHandler;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Spring MVC 配置
 *
 * @author trang
 */
@Configuration
public class Config {

  @Bean
    public NewTopic getNewTopic(){

      return TopicBuilder.name("v-wiki-topic").build();
  }

  @Bean
  public KafkaChangeHandler getNewWikiMediaEventHandler(){

    return new KafkaChangeHandler("v-wiki-topic");
  }



}