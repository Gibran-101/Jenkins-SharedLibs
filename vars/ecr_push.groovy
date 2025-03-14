def call(String projectName, String imageTag, String awsRegion, String ecrRepositoryUri, String dockerHubUser) {
  // Authenticate with AWS ECR
  sh "aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrRepositoryUri}"
  
  // Tag the image for ECR (accounting for the DockerHub username in the source image)
  sh "docker tag ${dockerHubUser}/${projectName}:${imageTag} ${ecrRepositoryUri}/${projectName}:${imageTag}"
  
  // Push the image to ECR
  sh "docker push ${ecrRepositoryUri}/${projectName}:${imageTag}"
}
