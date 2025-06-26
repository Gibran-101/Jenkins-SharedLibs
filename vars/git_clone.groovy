def call(String repoUrl, String branch = 'main') {
    echo "Cloning repo: ${repoUrl} on branch: ${branch}"
    git branch: branch, url: repoUrl
}

