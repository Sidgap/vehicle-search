package com.learn2code.vehicleapi.serachn.Entity;

public class FileUploadResponse {

	private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
	public FileUploadResponse(String fileName, String downloadURL, String fileType, long fileSize) {
		super();
		this.fileName = fileName;
		this.downloadURL = downloadURL;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}
	public FileUploadResponse() {
		
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDownloadURL() {
		return downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
    
	
    
}
