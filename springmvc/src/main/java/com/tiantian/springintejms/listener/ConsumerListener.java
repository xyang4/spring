package com.tiantian.springintejms.listener;

public class ConsumerListener {

	/**
	 * @描述 spring不指定defaultListenerMethod时默认调用
	 * @date 2016年11月5日-下午7:06:14
	 * @param message
	 */
	public void handleMessage(String message) {
		System.out.println("ConsumerListener通过handleMessage接收到一个纯文本消息，消息内容是：" + message);
	}

//	public void receiveMessage(String message) {
//		System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
//	}

	/**
	 * 当返回类型是非null时MessageListenerAdapter会自动把返回值封装成一个Message，然后进行回复，返回null或void时MessageListenerAdapter不作消息的自动回复
	 * 
	 * @param message
	 * @return
	 */
	public String receiveMessage(String message) {
		System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
		return "这是ConsumerListener对象的receiveMessage方法的返回值。";
	}
}