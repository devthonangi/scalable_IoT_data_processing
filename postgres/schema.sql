CREATE TABLE vehicle_iot_data (
    id SERIAL PRIMARY KEY,
    vehicle_id VARCHAR(50),
    speed DOUBLE PRECISION,
    acceleration DOUBLE PRECISION,
    braking_force DOUBLE PRECISION,
    gps_latitude DOUBLE PRECISION,
    gps_longitude DOUBLE PRECISION,
    timestamp BIGINT
);
