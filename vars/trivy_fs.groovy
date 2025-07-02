def call() {
    echo "Running Trivy scan on file system..."
    sh 'trivy fs .'
}
