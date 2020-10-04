## Spring Boot Embedded ActiveMQ Configuration
Spring Boot can automatically configure a ConnectionFactory when it detects that ActiveMQ is available on the class-path. If the broker is present, an embedded broker is started and configured automatically (as long as no broker URL is specified through configuration).

You can configure spring using the application.yml file or by using an application.properties file.

## Spring ActiveMQ Configuration
The `@EnableJms` enables JMS listener annotated endpoints that are created under the cover by `JmsListenerContainerFactory`. The `JmsListenerContainerFactory` is responsible to create the listener container responsible for a particular endpoint. 

The `@EnableJms` annotation also enables detection of `@JmsListener` on any Spring-managed beans in the container. The `MappingJackson2MessageConverter` uses Jackson to convert messages to and from JSON. We create a `DefaultJmsListenerContainerFactory` and assign the previously created MessageConverter.

## Sending Messages to JMS Queue
Now we have configured the Embedded ActiveMQ message broker, we can start sending/producing messages to an ActiveMQ Queue. We use the JmsTemplate to send/publish JMS messages on the queue. We simply need to pass in a destination and message arguments and the JmsTemplate handles the rest.

## Consuming Messages from JMS Queue
The `@JmsListener` annotation marks a method to be the target of a JMS message listener on the specified destination. Annotated JMS listener methods are allowed to have flexible signatures.

* `javax.jms.Session` to get access to the JMS session.
* `javax.jms.Message` or one of its subclasses to get access to the raw JMS message.
* `org.springframework.messaging.handler.annotation.Payload` @Payload-annotated method arguments, including support for validation.
* `org.springframework.messaging.handler.annotation.Header` @Header – annotated method arguments to extract specific header values, including standard JMS headers defined by org.springframework.jms.support.JmsHeaders.
* `org.springframework.messaging.handler.annotation.Headers` @Headers – annotated method argument that must also be assignable to java.util.Map for obtaining access to all headers.
* `org.springframework.messaging.MessageHeaders` arguments for obtaining access to all headers.
* `org.springframework.messaging.support.MessageHeaderAccessor` or `org.springframework.jms.support.JmsMessageHeaderAccessor` for convenient access to all method arguments.

Annotated methods may have a non-void return type. When they do, the result of the method invocation is sent as a JMS reply to the destination defined by the JMSReplyTo header of the incoming message. If this header is not set, a default destination can be provided by adding `org.springframework.messaging.handler.annotation.SendTo` `@SendTo` to the method declared.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring for Apache ActiveMQ 5](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-activemq)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Java Message Service API via Apache ActiveMQ Classic.](https://spring.io/guides/gs/messaging-jms/)

