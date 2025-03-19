package com.iot.consumer.listener;

import com.google.gson.Gson;
import com.iot.consumer.model.VehicleIoTData;
import com.iot.consumer.repository.VehicleIoTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class IoTConsumer {

    @Autowired
    private VehicleIoTRepository repository;

    @KafkaListener(topics = "iot-sensor-data", groupId = "iot-group")
    public void consume(String message) {
        VehicleIoTData data = new Gson().fromJson(message, VehicleIoTData.class);

        // Detect harsh braking (Threshold: acceleration < -4.0 and braking force > 7.0)
        if (data.getAcceleration() < -4.0 && data.getBrakingForce() > 7.0) {
            System.out.println("🚨 Harsh Braking Detected for Vehicle: " + data.getVehicleId());
        }

        repository.save(data);
    }
}
