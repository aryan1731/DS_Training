package dao;

//import entities;

import java.util.List;

import entities.Department;

//II. POJI
public interface DepartmentDAO { //POJI as per the POJO

	public void insertDepartment(Department dept); //C
	public Department selectDepartment(int deptNumber);//R
	public List<entities.Department> selectDepartments(); //RA
	public void updateDepartment(Department dept); //U
	public void deleteDepartment(int deptNumber);  //D
	
}
