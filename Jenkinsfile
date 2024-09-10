pipeline {
    agent any
    environment {
        // Android SDK 경로 설정
        ANDROID_HOME = "/path/to/your/android-sdk"
         PATH = "${env.PATH}:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools"
    }
    stages {
        stage('Checkout') {
            steps {
                // GitHub에서 소스 코드 체크아웃
                checkout scm
            }
        }

        stage('Build APK') {
            steps {
                // Gradle로 빌드
                sh './gradlew clean assembleRelease'
            }
        }
    }

    post {
        success {
            // 빌드 후 APK 파일을 아카이브
            archiveArtifacts artifacts: 'app/build/outputs/apk/**/*.apk', allowEmptyArchive: true
        }
        failure {
            // 빌드 실패 시 로그 출력
            echo 'Build failed!'
        }
    }
}
