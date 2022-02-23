package com.pdp.uplod;

import java.awt.List;
import java.math.BigInteger;

public class FileClintBean {
	
	private List files ;
	private List macs ;
	private BigInteger userBublicKey;
	
	
	public List getFiles() {
		return files;
	}
	public void setFiles(List files) {
		this.files = files;
	}
	public List getMacs() {
		return macs;
	}
	public void setMacs(List macs) {
		this.macs = macs;
	}
	public BigInteger getUserBublicKey() {
		return userBublicKey;
	}
	public void setUserBublicKey(BigInteger userBublicKey) {
		this.userBublicKey = userBublicKey;
	}
	
	

}
