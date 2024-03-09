package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class homeCotroller {
	@Autowired
	StudentService ss;

	@Autowired
	private FileUploadHelper FUH;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}

	@GetMapping("/welcome")
	public List<Student> display() {

		return ss.display();
	}

	@PostMapping("/next")
	public String next(@RequestBody Student s2) {
		ss.reg(s2);
		return "submit";
	}

	@GetMapping("/edit/{id}")
	public ResponseEntity<Student> editemp(@PathVariable int id) {
		Student s = ss.getsingledata(id); // .orElseThrow(()-> new ResourceNotFoundException("Student not found by id" +
											// id));
		return ResponseEntity.ok(s);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateemp(@PathVariable int id, @RequestBody Student s2) {
		Student s = ss.getsingledata(id); // .orElseThrow(()-> new ResourceNotFoundException("Student not found by id" +
											// id));
		s.setSname(s2.getSname());
		s.setSemail(s2.getSemail());
		s.setSphoto(s2.getSphoto());

		Student sss = ss.update(s);
		return ResponseEntity.ok(sss);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Map<String, Boolean>> delemp(@PathVariable int id) {
		Student s = ss.getsingledata(id);
		ss.delemp(id);
		Map<String, Boolean> m = new HashMap<>();
		m.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(m);
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

		try {
			// validation
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
			}

			// file upload code
			boolean f = FUH.uploadfile(file);
			if (f) {
				return ResponseEntity.ok("Uploaded successfully!");

			}

		} catch (Exception e) {
			// TODO : handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
	}
}
