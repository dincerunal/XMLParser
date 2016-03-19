package com.altay.main;

/**
 * @author unal
 *
 */
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Read xml = new Read();
		Write write = new Write(xml.Read());
	}

}
