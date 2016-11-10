package tasks.util;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

public class Timer {
	private long startTime = 0;
	private long endTime = 0;
	Logger log = Logger.getLogger(Timer.class);
	// simple timer class
	// class to time

	public void start() throws IOException {
		startTime = System.currentTimeMillis();
		log.info("TIMER START -> " + this.dateParser(startTime));
	}

	public void end() throws IOException {
		this.endTime = System.currentTimeMillis();
		log.info("TIMER END -> " + this.dateParser(this.endTime));
	}

	public Date getStartTime() throws IOException {
		log.info("GET START -> " + this.dateParser(this.startTime));
		return this.dateParser(this.startTime);
	}

	public Date getEndTime() throws IOException {
		log.info("GET END -> " + this.dateParser(this.endTime));
		return this.dateParser(this.endTime);
	}

	public long getTotalTime() throws IOException {
		long deltaTime = this.endTime - this.startTime;
		log.info("GET TOTAL -> " + deltaTime + " ms");
		return deltaTime;
	}

	public Date dateParser(long unixTime) {
		Date date = new Date();
		date.setTime(unixTime);
		return date;
	}
}