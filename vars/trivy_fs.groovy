def call() {
    echo "Running Trivy scan on file system..."

    sh '''
    if ! command -v trivy >/dev/null 2>&1; then
        echo "Installing Trivy..."
        sudo apt-get update
        sudo apt-get install -y wget
        wget https://github.com/aquasecurity/trivy/releases/latest/download/trivy_0.48.4_Linux-64bit.deb
        sudo dpkg -i trivy_0.48.4_Linux-64bit.deb
    fi

    trivy fs .
    '''
}

