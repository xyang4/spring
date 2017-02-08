package com.xyang.pattern.creational.factoryMethod.demo.impl;

import com.xyang.pattern.creational.factoryMethod.demo.IWork;
import com.xyang.pattern.creational.factoryMethod.demo.IWorkFactory;

public class StudentWorkFactoryImpl implements IWorkFactory {

	@Override
	public IWork getWork() {
		return new StudentWorkImpl();
	}

}
