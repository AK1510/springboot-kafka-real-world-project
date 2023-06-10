package com.misterkourouma.trainings.springboot.service;

import com.misterkourouma.trainings.springboot.model.Wikimedia;
import com.misterkourouma.trainings.springboot.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaRepository wikimediaRepository;

    public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){

        LOGGER.info("Event message received -> {}", eventMessage);

        Wikimedia wikimedia = Wikimedia.builder()
                .wikiEventData(eventMessage)
                .build();

        wikimediaRepository.save(wikimedia);

        //LOGGER.info("Event message received -> {}", eventMessage);
    }

}
