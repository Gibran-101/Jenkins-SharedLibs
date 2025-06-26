def call(String project, String imageTag) {
  withCredentials([usernamePassword(credentialsId: 'DHC', usernameVariable: 'DHU', passwordVariable: 'DHP')]) {
    sh """
      echo "\$DHP" | docker login -u "\$DHU" --password-stdin
      docker tag ${project}:${imageTag} \$DHU/${project}:${imageTag}
      docker push \$DHU/${project}:${imageTag}
    """
  }
}
