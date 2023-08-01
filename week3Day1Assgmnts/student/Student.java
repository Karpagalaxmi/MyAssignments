package org.student;

import org.department.Department;

/*
 * Package   :org.college
     Class     :College
     Methods   :collegeName(),collegeCode(),collegeRank()

     Package   :org.department
     Class        :Department
     Methods   :deptName()
 
     Package   :org.student
     Class        :Student
     Methods   :studentName(),studentDept(),studentId()
  
Description:
create above 3 class and call all your class methods into the Student using multilevel inheritance.
 */

public class Student extends Department {

	public void studentName() {
		System.out.println("Student Name : Shiva");
	}
	
	public void studentDept() {
		System.out.println("Student Department : ECE");
	}
	
	public void studentID() {
		System.out.println("Student ID : 1470");
	}
	
	public static void main(String[] args) {
	 Student st = new Student();
	 st.collegeName();
	 st.collegeCode();
	 st.collegeRank();
	 st.deptName();
	 
	 st.studentName();
	 st.studentDept();
	 st.studentID();
}
	
}

