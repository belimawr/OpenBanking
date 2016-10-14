package br.com.original.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class OpenBankingToken implements Serializable {

	private static final long serialVersionUID = 6691918203190190254L;
	private static final String fileName = "/tmp/openbankingtoken.ser";

	String authCode;
	String uid;

	String accessToken;
	String refreshToken;
	Integer expiresIn;

	Boolean isExpired() {
		Calendar now = Calendar.getInstance();
		boolean expired = now.after(expiresIn);
		return expired;
	}

	Object deserialize() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	void serialize() throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		oos.close();
	}

	@Override
	public String toString() {
		return "OpenBankingToken [authCode=" + authCode + ", uid=" + uid + ", accessToken=" + accessToken
				+ ", refreshToken=" + refreshToken + ", expiresIn=" + expiresIn + "]";
	}

}
