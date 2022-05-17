package com.IqacBackend.IqacSpringBootfirstapp.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.IqacBackend.IqacSpringBootfirstapp.model.Doc;
import com.IqacBackend.IqacSpringBootfirstapp.repository.DocRepository;

import org.springframework.util.StringUtils;



@Service
public class DocStorageService {

	
	@Autowired
	private DocRepository docRepository;
	
  public Doc store(MultipartFile file) throws IOException {
  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
  Doc doc = new Doc(fileName, file.getContentType(), file.getBytes());
  return docRepository.save(doc);
}
	
	
	
//	public Doc saveFile(MultipartFile file) {
//		String docname = file.getOriginalFilename();
//		try {
//			Doc doc = new Doc(docname,file.getContentType(),file.getBytes());
//			return docRepository.save(doc);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
  
  public Doc getFile(String id) {
    return docRepository.findById(id).get();
  }
//	public Optional<Doc> getFile(Integer fileId) {
//		return docRepository.findById(fileId);
//	}
	
//	public List<Doc> getFiles(){
//		 	return docRepository.findAll();
//	}

  public Stream<Doc> getAllFiles() {
  return docRepository.findAll().stream();
}
	
	
}



//package com.bezkoder.spring.files.upload.db.service;
//import java.io.IOException;
//import java.util.stream.Stream;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//import com.bezkoder.spring.files.upload.db.model.FileDB;
//import com.bezkoder.spring.files.upload.db.repository.FileDBRepository;
//@Service
//public class FileStorageService {
//  @Autowired
//  private FileDBRepository fileDBRepository;
//  public FileDB store(MultipartFile file) throws IOException {
//    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
//    return fileDBRepository.save(FileDB);
//  }
//  public FileDB getFile(String id) {
//    return fileDBRepository.findById(id).get();
//  }
//  
//  public Stream<FileDB> getAllFiles() {
//    return fileDBRepository.findAll().stream();
//  }
//}
