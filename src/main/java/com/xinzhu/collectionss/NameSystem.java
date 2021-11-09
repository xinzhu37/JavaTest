package com.xinzhu.collectionss;

//定义一个NameSystem类
class NameSystem{
	private String name;
	private int times;
//定义有参构造器
	public NameSystem(String name,int times) {
		this.setName(name);
		this.setTimes(times);
	}
//以下是getset操作
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
}
