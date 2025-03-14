def call(String projectName, String imageTag, String awsRegion, String ecrRepositoryUri) {
  // Authenticate with AWS ECR
  sh "aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrRepositoryUri}"
  
  // Tag the image for ECR
  sh "docker tag ${projectName}:${imageTag} ${ecrRepositoryUri}/${projectName}:${imageTag}"
  
  // Push the image to ECR
  sh "docker push ${ecrRepositoryUri}/${projectName}:${imageTag}"
}
