package com.iot.consumer.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle_iot_data")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class VehicleIoTData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleId;
    private double speed;
    private double acceleration;
    private double brakingForce;
    private double gpsLatitude;
    private double gpsLongitude;
    private long timestamp;
}
