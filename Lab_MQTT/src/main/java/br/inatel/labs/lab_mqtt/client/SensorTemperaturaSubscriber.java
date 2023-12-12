package br.inatel.labs.lab_mqtt.client;

import org.eclipse.paho.client.mqttv3.*;

import java.util.Arrays;
import java.util.UUID;

public class SensorTemperaturaSubscriber {

    public static void main(String[] args) {

        String subscriberId = UUID.randomUUID().toString();
       
        IMqttClient subscriber = new MqttClient( MyConstants.URI_BROKER, subscriberId);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        subscriber.connect(options);

        subscriber.subscribe(MyConstants.TOPIC_SENSOR, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            System.out.println( "Payload recebido: " + payload);
            System.out.println( "Topico recebido: " + topic );
        });


        subscriber.close();
        
    }


}
