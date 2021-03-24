package com.knoldus.KafkaClasses;

import com.knoldus.UserPojo.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args) throws Exception {

        Properties p=new Properties();
        p.put("bootstrap.servers", "localhost:9092");
        p.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        p.put("value.deserializer","com.knoldus.SerializedDeserialized.ObjectDeserialization");
        p.put("group.id","test-group");

        KafkaConsumer<String, User> kc=new KafkaConsumer<String,User>(p);

        List topics=new ArrayList();
        topics.add("User");
        kc.subscribe(topics);

        while(true)
        {
            ConsumerRecords<String,User> rec= kc.poll(Duration.ofMillis(1000));

            for (ConsumerRecord<String,User> record : rec){

                System.out.println("Id="+String.valueOf(record.value().getUser_id())+" Age="+String.valueOf(record.value().getUser_age())+" Name="+String.valueOf(record.value().getUser_name())+" Course="+String.valueOf(record.value().getUser_course()));
                FileWriter fw=new FileWriter("MyFile.txt",true);
                fw.write("Id="+String.valueOf(record.value().getUser_id())+" Age="+String.valueOf(record.value().getUser_age())+" Name="+String.valueOf(record.value().getUser_name())+" Course="+String.valueOf(record.value().getUser_course())+"\n");
                 fw.close();



            }
        }


    }

}
