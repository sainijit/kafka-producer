FROM fabric8/s2i-java:2.3
ENV JAVA_APP_DIR=/deployments
LABEL org.label-schema.description="" org.label-schema.version=0.0.1-SNAPSHOT org.label-schema.schema-version=1.0 org.label-schema.build-date=2021-06-29T07:39:39.065 org.label-schema.name=kafka-producer-ocp org.label-schema.vcs-ref=9f23a04a1c3cfcb0a3a3638792137305b5ddd004 org.label-schema.vcs-url=https://github.com/rh-maggarwa/amq-streams.git
EXPOSE 8080 8778 9779
COPY maven /deployments/
