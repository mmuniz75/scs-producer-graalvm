Prereqs:
- Start a local kafka server on port 9092
- Install GraalVM : 
      - curl -s "https://get.sdkman.io" | bash
      - sdk install java 22.3.r17-nik
      - sdk use java 22.3.r17-nik

Steps to reproduce the issue:

- git clone https://github.com/mmuniz75/scs-producer-graalvm.git

- cd scs-producer-graalvm
 
- sudo chmod +x gradlew

- ./gradlew nativeCompile

- ./plates-producer/build/native/nativeCompile/./plates-producer

When Spring starts will fail to poll to Kafka topic plate with errors :

2024-01-25T08:50:05.062-03:00 ERROR 8025 --- [sp-sc-cfc] [           main] o.s.cloud.stream.binding.BindingService  : Failed to create producer binding; retrying in 30 seconds
org.springframework.cloud.stream.binder.BinderException: Cannot initialize binder checking the topic (plates):
	at org.springframework.cloud.stream.binder.kafka.provisioning.KafkaTopicProvisioner.getPartitionsForTopic(KafkaTopicProvisioner.java:684) ~[sp-sc-cfc:4.1.0]
	at org.springframework.cloud.stream.binder.kafka.provisioning.KafkaTopicProvisioner.getPartitionInfoForProducer(KafkaTopicProvisioner.java:600) ~[sp-sc-cfc:4.1.0]
	at org.springframework.cloud.stream.binder.kafka.KafkaMessageChannelBinder.createProducerMessageHandler(KafkaMessageChannelBinder.java:422) ~[sp-sc-cfc:4.1.0]
	at org.springframework.cloud.stream.binder.kafka.KafkaMessageChannelBinder.createProducerMessageHandler(KafkaMessageChannelBinder.java:168) ~[sp-sc-cfc:4.1.0]
	at org.springframework.cloud.stream.binder.AbstractMessageChannelBinder.doBindProducer(AbstractMessageChannelBinder.java:310) ~[sp-sc-cfc:4.1.0]
	at org.springframework.cloud.stream.binder.AbstractMessageChannelBinder.doBindProducer(AbstractMessageChannelBinder.java:102) ~[sp-sc-cfc:4.1.0]


2024-01-25T08:50:05.064-03:00 ERROR 8025 --- [sp-sc-cfc] [   scheduling-1] o.s.integration.handler.LoggingHandler   : org.springframework.messaging.MessageDeliveryException: Dispatcher has no subscribers for channel 'platesToCheck-out-0'., failedMessage=GenericMessage [payload=plate: "SIE7D3K"
, headers={sequenceNumber=1, correlationId=63e8b192-568c-c9b1-0867-52deb3eefce4, id=672f42d3-a458-0c59-b2e4-5841806869f2, sequenceSize=0, timestamp=1706183405063}]
	at org.springframework.integration.channel.AbstractSubscribableChannel.doSend(AbstractSubscribableChannel.java:76)
	at org.springframework.integration.channel.AbstractMessageChannel.sendInternal(AbstractMessageChannel.java:378)
	at org.springframework.integration.channel.AbstractMessageChannel.sendWithMetrics(AbstractMessageChannel.java:349)
	at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:329)
	at org.springframework.messaging.core.GenericMessagingTemplate.doSend(GenericMessagingTemplate.java:187)
	at org.springframework.messaging.core.GenericMessagingTemplate.doSend(GenericMessagingTemplate.java:166)
	at org.springframework.messaging.core.GenericMessagingTemplate.doSend(GenericMessagingTemplate.java:47)
	at org.springframework.messaging.core.AbstractMessageSendingTemplate.send(AbstractMessageSendingTemplate.java:109)
	at org.springframework.integration.router.AbstractMessageRouter.doSend(AbstractMessageRouter.java:228)
	at org.springframework.integration.router.AbstractMessageRouter.handleMessageInternal(AbstractMessageRouter.java:210)
	at org.springframework.integration.handler.AbstractMessageHandler.doHandleMessage(AbstractMessageHandler.java:105)
	at org.springframework.integration.handler.AbstractMessageHandler.handleWithMetrics(AbstractMessageHandler.java:90)
	at org.springframework.integration.handler.AbstractMessageHandler.handleMessage(AbstractMessageHandler.java:70)
	at org.springframework.integration.dispatcher.AbstractDispatcher.tryOptimizedDispatch(AbstractDispatcher.java:132)
	at org.springframework.integration.dispatcher.UnicastingDispatcher.doDispatch(UnicastingDispatcher.java:133)
	at org.springframework.integration.dispatcher.UnicastingDispatcher.dispatch(UnicastingDispatcher.java:106)
	at org.springframework.integration.channel.AbstractSubscribableChannel.doSend(AbstractSubscribableChannel.java:72)
	at org.springframework.integration.channel.AbstractMessageChannel.sendInternal(AbstractMessageChannel.java:378)
	at org.springframework.integration.channel.AbstractMessageChannel.sendWithMetrics(AbstractMessageChannel.java:349)
	at org.springframework.integration.channel.AbstractMessageChannel.send(AbstractMessageChannel.java:329)
	at org.springframework.messaging.core.GenericMessagingTemplate.doSend(GenericMessagingTemplate.java:187)
	at org.springframework.messaging.core.GenericMessagingTemplate.doSend(GenericMessagingTemplate.java:166)
	at org.springframework.messaging.core.GenericMessagingTemplate.doSend(GenericMessagingTemplate.java:47)



