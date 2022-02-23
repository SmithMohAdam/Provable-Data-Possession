package com.pdp.cloud;

import java.awt.List;
import java.io.File;
import java.math.BigInteger;

public class FileBean {
	
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
	

}
