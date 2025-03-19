output "kafka_brokers" {
  value = aws_msk_cluster.kafka_cluster.bootstrap_brokers
}

output "database_endpoint" {
  value = aws_db_instance.iot_db.endpoint
}
