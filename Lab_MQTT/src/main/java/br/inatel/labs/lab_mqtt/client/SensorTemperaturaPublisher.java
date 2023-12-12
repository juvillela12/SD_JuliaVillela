package br.inatel.labs.lab_mqtt.client;
import org.eclipse.paho.client.mqttv3.*;

import java.util.Random;
import java.util.UUID;

public class SensorTemperaturaPublisher {

    private static MqttMessage getTemperatureMessage() {
        Random r = new Random();
        double temperatura = 80 + r.nextDouble() * 20.0;
        byte[] payload = String.format("T:%04.2f", temperatura).getBytes();
        return new MqttMessage(payload);
    }

    public static void main(String[] args) {

        String publisherId = UUID.randomUUID().toString();
        IMqttClient publisher = new MqttClient(MyConstants.URI_BROKER,publisherId);


        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        publisher.connect(options);

        for (int i = 0; i < 10; i++) {

            MqttMessage msg = getTemperatureMessage();
            msg.setQos(0);
            msg.setRetained(true);

            publisher.publish(MyConstants.TOPIC_SENSOR, msg);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        publisher.disconnect();
        publisher.close();

    }

}
