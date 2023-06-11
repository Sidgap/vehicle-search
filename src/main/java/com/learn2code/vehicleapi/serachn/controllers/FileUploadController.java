package com.learn2code.vehicleapi.serachn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn2code.vehicleapi.serachn.Entity.FileUpload;
import com.learn2code.vehicleapi.serachn.Entity.FileUploadResponse;
import com.learn2code.vehicleapi.serachn.services.FileUploadServiceimpl;

@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {
	
	@Autowired
	private FileUploadServiceimpl fileUploadServiceimpl;
	
	 @PostMapping("/upload")
	    public FileUploadResponse uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
	        FileUpload attachment = null;
	        String downloadUrl = "";
	        attachment = fileUploadServiceimpl.saveFile(file);
	        downloadUrl = ServletUriComponentsBuilder
	                .fromCurrentContextPath()
	                .path("/download/")
	                .path(attachment.getId())
	                .toUriString();
	        return new FileUploadResponse(attachment.getFileName(), downloadUrl, file.getContentType(), file.getSize());

	    }

	    @GetMapping("/download/{fileId}")
	    public ResponseEntity<Resource> download(@PathVariable("fileId")String fileId) throws Exception {
	        FileUpload fileUpload = null;
	        fileUpload = fileUploadServiceimpl.downloadFile(fileId);
	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(fileUpload.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "fileUpload; filename=\""+ fileUpload.getFileName()
	                        +"\"").body(new ByteArrayResource(fileUpload.getData()));
	    }

}
