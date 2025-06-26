def call() {
    echo "Running Trivy scan on file system..."

    sh '''
    if ! command -v trivy >/dev/null 2>&1; then
        echo "Installing Trivy..."
        sudo apt-get update
        sudo apt-get install -y wget curl

        TRIVY_VERSION=$(curl -s https://api.github.com/repos/aquasecurity/trivy/releases/latest | grep tag_name | cut -d '"' -f 4)
        TRIVY_DEB="trivy_${TRIVY_VERSION#v}_Linux-64bit.deb"

        wget https://github.com/aquasecurity/trivy/releases/download/$TRIVY_VERSION/$TRIVY_DEB -O trivy.deb
        sudo dpkg -i trivy.deb
    fi

    trivy fs .
    '''
}
