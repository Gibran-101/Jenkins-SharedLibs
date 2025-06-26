def call(String project, String imageTag) {
  withCredentials([usernamePassword(credentialsId: 'DHC', usernameVariable: 'DHU', passwordVariable: 'DHP')]) {
    sh """
      echo "\$DOCKERHUB_PASS" | docker login -u "\$DOCKERHUB_USER" --password-stdin
      docker tag ${project}:${imageTag} \$DOCKERHUB_USER/${project}:${imageTag}
      docker push \$DOCKERHUB_USER/${project}:${imageTag}
    """
  }
}
