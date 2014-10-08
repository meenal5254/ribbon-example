This is just a test project. I am trying to integrate my application with ribbon-2.0-RC9.

NOTE: This code runs fine if we use ribbon-2.0-RC7.

I am spinning my own web-server using jetty. This part of the code is present in "example-war". There is a test-case in example-impl which just check the contents of the web-service, I started using example-war. It should return "hello" instead it returns an Error:

```
testConnection(com.ribbon.example.impl.ExampleTest): Sequence contains no elements
```

This is just a test for the things I am doing, the error message I am getting in my project looks like:

```
java.util.NoSuchElementException: Sequence contains no elements
	at rx.internal.operators.OperatorSingle$1.onCompleted(OperatorSingle.java:79)
	at rx.subjects.SubjectSubscriptionManager$SubjectObserver.onCompleted(SubjectSubscriptionManager.java:232)
	at rx.internal.operators.NotificationLite.accept(NotificationLite.java:125)
	at rx.subjects.ReplaySubject$UnboundedReplayState.accept(ReplaySubject.java:375)
	at rx.subjects.ReplaySubject$UnboundedReplayState.replayObserverFromIndex(ReplaySubject.java:415)
	at rx.subjects.ReplaySubject$UnboundedReplayState.replayObserver(ReplaySubject.java:404)
	at rx.subjects.ReplaySubject.caughtUp(ReplaySubject.java:335)
	at rx.subjects.ReplaySubject.onCompleted(ReplaySubject.java:319)
	at rx.Observable$29.onCompleted(Observable.java:6798)
	at rx.observers.SafeSubscriber.onCompleted(SafeSubscriber.java:83)
	at rx.internal.operators.OperatorMap$1.onCompleted(OperatorMap.java:43)
	at rx.internal.operators.OperatorDoOnEach$1.onCompleted(OperatorDoOnEach.java:44)
	at rx.internal.operators.OperatorOnErrorResumeNextViaFunction$1.onCompleted(OperatorOnErrorResumeNextViaFunction.java:57)
	at rx.internal.operators.OperatorDoOnEach$1.onCompleted(OperatorDoOnEach.java:44)
	at rx.internal.operators.OperatorMap$1.onCompleted(OperatorMap.java:43)
	at rx.internal.operators.OperatorDoOnEach$1.onCompleted(OperatorDoOnEach.java:44)
	at rx.internal.operators.OperatorOnErrorResumeNextViaFunction$1.onCompleted(OperatorOnErrorResumeNextViaFunction.java:57)
	at rx.internal.operators.OperatorMap$1.onCompleted(OperatorMap.java:43)
	at com.netflix.hystrix.HystrixObservableCommand$HystrixObservableTimeoutOperator$3.onCompleted(HystrixObservableCommand.java:849)
	at rx.internal.operators.OperatorDoOnEach$1.onCompleted(OperatorDoOnEach.java:44)
	at rx.observers.SerializedObserver.onCompleted(SerializedObserver.java:98)
	at rx.observers.SerializedSubscriber.onCompleted(SerializedSubscriber.java:46)
	at rx.internal.operators.OperatorMerge$MergeSubscriber.completeInner(OperatorMerge.java:87)
	at rx.internal.operators.OperatorMerge$InnerSubscriber.onCompleted(OperatorMerge.java:122)
	at rx.internal.operators.OperatorMap$1.onCompleted(OperatorMap.java:43)
	at io.reactivex.netty.protocol.http.UnicastContentSubject$PassThruObserver.onCompleted(UnicastContentSubject.java:345)
	at io.reactivex.netty.protocol.http.UnicastContentSubject.onCompleted(UnicastContentSubject.java:300)
	at io.reactivex.netty.protocol.http.client.ClientRequestResponseConverter$ResponseState.sendOnComplete(ClientRequestResponseConverter.java:302)
	at io.reactivex.netty.protocol.http.client.ClientRequestResponseConverter$ResponseState.access$300(ClientRequestResponseConverter.java:280)
	at io.reactivex.netty.protocol.http.client.ClientRequestResponseConverter.channelRead(ClientRequestResponseConverter.java:133)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:333)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:319)
	at io.netty.channel.ChannelInboundHandlerAdapter.channelRead(ChannelInboundHandlerAdapter.java:86)
	at io.reactivex.netty.contexts.AbstractClientContextHandler.channelRead(AbstractClientContextHandler.java:63)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:333)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:319)
	at io.netty.handler.codec.MessageToMessageDecoder.channelRead(MessageToMessageDecoder.java:103)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:333)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:319)
	at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:163)
	at io.netty.channel.CombinedChannelDuplexHandler.channelRead(CombinedChannelDuplexHandler.java:148)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:333)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:319)
	at io.netty.handler.logging.LoggingHandler.channelRead(LoggingHandler.java:283)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:333)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:319)
	at io.netty.channel.ChannelInboundHandlerAdapter.channelRead(ChannelInboundHandlerAdapter.java:86)
	at io.reactivex.netty.metrics.BytesInspector.channelRead(BytesInspector.java:56)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:333)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:319)
	at io.netty.handler.timeout.ReadTimeoutHandler.channelRead(ReadTimeoutHandler.java:150)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:333)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:319)
	at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:787)
	at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:125)
	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:511)
	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:468)
	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:382)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:354)
	at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:116)
	at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:137)
	at java.lang.Thread.run(Thread.java:695)
```