package com.accenturedemo.soapservice;

import org.springframework.stereotype.Service;

import com.howtodoinjava.xml.school.ObjectFactory;
import com.howtodoinjava.xml.school.Student;
import com.howtodoinjava.xml.school.StudentDetailsPort;
import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsResponse;

@Service
public class StudentServiceEndpoint implements StudentDetailsPort{

	@Override
	public StudentDetailsResponse studentDetails(StudentDetailsRequest studentDetailsRequest) {
		
		ObjectFactory factory = new ObjectFactory();
		
		StudentDetailsResponse resp = factory.createStudentDetailsResponse();
		Student std = factory.createStudent();
		std.setName("SaurabhGoel");
		std.setStandard(88);
		std.setAddress("Kallang River walk");
		
		resp.setStudent(std);
		
		return resp;
	}

}
