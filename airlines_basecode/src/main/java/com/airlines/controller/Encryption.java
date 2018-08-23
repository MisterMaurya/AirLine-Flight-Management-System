package com.airlines.controller;

import java.security.MessageDigest;

public class Encryption {

	public static String encrptPass(String pass) throws Exception {
		StringBuffer encrptPass = null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pass.getBytes());
		byte b[] = md.digest();

		encrptPass = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			encrptPass.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
		}
		return encrptPass.toString();
	}
}
