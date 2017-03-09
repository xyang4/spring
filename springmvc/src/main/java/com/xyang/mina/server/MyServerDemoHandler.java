package com.xyang.mina.server;

import java.util.Date;

import org.apache.http.client.utils.DateUtils;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServerDemoHandler implements IoHandler {
	private static final Logger logger = LoggerFactory.getLogger(MyServerDemoHandler.class);

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		logger.info("sesionID[{}] --> sessionCreated", session.getId(), session.getId());
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("sesionID[{}] --> sessionOpened", session.getId());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		logger.info("sesionID[{}] --> sessionClosed", session.getId());
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		logger.info("sesionID[{}] --> sessionIdle", session.getId());
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		logger.info("sesionID[{}] --> exceptionCaught", session.getId());
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String msg = (String) message;
		logger.info("sesionID[{}] -->server messageReceived msg[{}].", session.getId(), message);
		if (msg.trim().equalsIgnoreCase("exit")) {
			session.closeNow();
		}
		session.write(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		logger.info("sesionID[{}] --> messageSent msg[{}].", session.getId(), message);
		//短连接
		session.closeNow();
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		logger.info("sesionID[{}] --> inputClosed", session.getId());
	}

}