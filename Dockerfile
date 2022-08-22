FROM gradle

RUN echo Y | apt update && \
    echo Y | apt install android-sdk

ENV ANDROID_HOME=/usr/lib/android-sdk

#RUN apt install openjdk-11-jre

RUN wget https://dl.google.com/android/repository/commandlinetools-linux-6609375_latest.zip && \
    unzip commandlinetools-linux-6609375_latest.zip -d cmdline-tools && \
    mkdir --parents "$ANDROID_HOME/cmdline-tools/latest" && \
    mv cmdline-tools/* "$ANDROID_HOME/cmdline-tools/latest/" && \
    export PATH=$ANDROID_HOME/cmdline-tools/latest/bin:$PATH

RUN $ANDROID_HOME/cmdline-tools/latest/tools/bin/sdkmanager --sdk_root=$ANDROID_HOME --licenses

COPY . /AppiumTests