FROM openjdk:8-jre-alpine
EXPOSE 8080
ADD demo/target/demo-1.0-SNAPSHOT.jar /usr/share/app/demo-1.0-SNAPSHOT.jar
ADD demo/model/XGBoost_grid_1_AutoML_20190828_132329_model_3.zip /usr/share/app/model.zip
CMD ["/usr/bin/java", "-jar", "/usr/share/app/demo-1.0-SNAPSHOT.jar", "/usr/share/app/model.zip"]