# Use official OpenJDK image
FROM eclipse-temurin:17-jdk

# Install dependencies
RUN apt-get update && apt-get install -y wget unzip xvfb libxi6 libgconf-2-4

# Install Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
 && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
 && apt-get update \
 && apt-get install -y google-chrome-stable

# Install ChromeDriver (match Chrome version; example uses version 114)
ARG CHROMEDRIVER_VERSION=114.0.5735.90
RUN wget -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/${CHROMEDRIVER_VERSION}/chromedriver_linux64.zip \
 && unzip /tmp/chromedriver.zip -d /usr/local/bin/ \
 && rm /tmp/chromedriver.zip \
 && chmod +x /usr/local/bin/chromedriver

# Set display port for headless Chrome
ENV DISPLAY=:99

# Copy project files
COPY . /app
WORKDIR /app

# Build your project (if using Gradle wrapper)
RUN ./gradlew clean test --no-daemon

# Default command to run tests
CMD ["./gradlew", "test", "--no-daemon"]
