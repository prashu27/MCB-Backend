package com.mcb.assessment.service;

import com.mcb.assessment.exceptionhandler.TeacherNotFound;
import com.mcb.assessment.model.*;
import com.mcb.assessment.repository.MarkRepository;
import com.mcb.assessment.repository.StudentRepository;
import com.mcb.assessment.repository.TeacherRepository;
import com.mcb.assessment.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

	@MockBean
	StudentRepository studentRepository;

	@MockBean
	MarkRepository markRepository;

	@InjectMocks
	StudentServiceImpl studentService;

	@MockBean
	TeacherRepository teacherRepository;

	@Test
	void addStudent () {
		Set<Student> students = new HashSet<> ();
		Group g = new Group (1, "A", students);
		Student s = new Student (1l, "prashansa", "shukla", g);
		Mockito.when (studentRepository.save (any ())).thenReturn (s);
		Student actual = studentService.addStudent (s);
		assert (actual.getFirstName ().equals (s.getFirstName ()));

	}

	@Test
	void getByStudentId () {
		Set<Student> students = new HashSet<> ();
		Group g = new Group (1, "A", students);
		Student s = new Student (1l, "prashansa", "shukla", g);
		Mockito.when (studentRepository.findById (1l)).thenReturn (Optional.of (s));
		Student actual = studentService.getByStudentId (1l);
		assert (actual.getFirstName ().equals (s.getFirstName ()));
	}


	@Test
	void getListOfMarksByStudentId () {
		Set<Mark> marks = new HashSet<> ();
		marks.add (new Mark ());
		Mockito.when (markRepository.findByStudentStudentId (1l)).thenReturn (marks);
		Set<Mark> actual = studentService.getListOfMarksByStudentId (1l);
		assert (actual.equals (marks));
	}


	@Test
	void failGetNoOfStudentsByTeacherId () {
		Mockito.when (studentRepository.findById (1l)).thenReturn (Optional.ofNullable (null));
		assertThrows (TeacherNotFound.class, () -> studentService.getByTeacherId (1l));

	}

	@Test
	void GetNoOfStudentsByTeacherId () {
		Set<Student> students = new HashSet<> ();
		Subject subject = new Subject ();
		Group group = new Group (1, "A", students);
		Student s = new Student (1l, "prashansa", "shukla", group);
		students.add (s);
		Teacher teacherObj = new Teacher (1, subject, group);
		Mockito.when (teacherRepository.findById (1l)).thenReturn (Optional.of (teacherObj));
		assertEquals (1l, studentService.getByTeacherId (1l));

	}
}