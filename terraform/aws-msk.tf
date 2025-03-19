resource "aws_msk_cluster" "kafka_cluster" {
  cluster_name           = "iot-kafka-cluster"
  kafka_version          = "2.8.1"
  number_of_broker_nodes = 3

  broker_node_group_info {
    instance_type = "kafka.m5.large"
    client_subnets = ["subnet-12345", "subnet-67890"]
    security_groups = ["sg-abcdef"]
  }
}
