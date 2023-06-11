package com.learn2code.vehicleapi.serachn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.learn2code.vehicleapi.serachn.Dao.FileUploadDao;
import com.learn2code.vehicleapi.serachn.Entity.FileUpload;


@Service
public class FileUploadServiceimpl  {

	
	@Autowired
	private FileUploadDao fileuploaddao;;

    public FileUpload saveFile(MultipartFile file) throws Exception   {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            try {
                if (fileName.contains("..")) {
                    throw new Exception("The file name is invalid" + fileName);
                }
                FileUpload fileUpload = new FileUpload(fileName, file.getContentType(), file.getBytes());
                return fileuploaddao.save(fileUpload);
            } catch (Exception e) {
                throw new Exception("File could not be save");
            }
        }

        public FileUpload downloadFile(String fileId) throws Exception   {
        return fileuploaddao.findById(fileId).orElseThrow(() -> new Exception("A file with Id : "+ fileId + " could not be found"));
              
        }

}
