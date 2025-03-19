package com.iot.api.controller;

import com.google.gson.Gson;
import com.iot.api.model.VehicleIoTData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleIoTController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "iot-sensor-data";

    @PostMapping("/send")
    public ResponseEntity<String> sendVehicleData(@RequestBody VehicleIoTData data) {
        kafkaTemplate.send(TOPIC, new Gson().toJson(data));
        return ResponseEntity.ok("Vehicle data sent to Kafka!");
    }
}
