package redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import redis.hash.HashMapping;
import redis.hash.Person;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

//    @Bean
//    RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate template = new RedisTemplate();
//        template.setConnectionFactory(connectionFactory);
//
//        return template;
//    }

    @Bean
    HashOperations<Object, byte[], byte[]> hashOperations(RedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        HashOperations<Object, byte[], byte[]> hashOperations = redisTemplate.opsForHash();

        return hashOperations;
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

//        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//        CountDownLatch latch = ctx.getBean(CountDownLatch.class);
//        log.info("sending message");
//        template.convertAndSend("chat", "hello from redis!");
//
//        latch.await();
//
//        System.exit(0);

//        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
//        HashOperations<Object, byte[], byte[]> hashOperations = redisTemplate.opsForHash();

        Person p = new Person();
        p.setFirstName("cloud");
        p.setLastName("chen");

        HashMapping mapping = new HashMapping();
        mapping.writeHash("1000", p);
    }
}
