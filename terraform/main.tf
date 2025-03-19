provider "aws" {
  region = "us-east-1"
}

module "kafka" {
  source = "./aws-msk.tf"
}

module "database" {
  source = "./aws-rds.tf"
}
