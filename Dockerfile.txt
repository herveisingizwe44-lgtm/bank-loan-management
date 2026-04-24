FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ["out/artifacts/BANK_OF_KIGALI_LOAN_MANAGEMENT_jar/BANK OF KIGALI LOAN MANAGEMENT.jar", "app.jar"]
CMD ["java", "-jar", "app.jar"]