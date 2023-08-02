package service;

import java.util.List;

import dao.DepartmentDAO;
import dao.DepartmentDAOImplementation;
import entities.Department;

//In The SERVICE
public class DepartmentServiceImplementation implements DepartmentService {
	DepartmentDAO deptDAO = new DepartmentDAOImplementation();
	public void createDepartmentService(Department dept) {
			deptDAO.insertDepartment(dept);
	}
	public Department findDepartmentService(int deptNumber) {	
		return deptDAO.selectDepartment(deptNumber);
	}
	public List<Department> findDepartmentsService() {
		return deptDAO.selectDepartments();
	}
	public void modifyDepartmentService(Department dept) {
		deptDAO.updateDepartment(dept);
	}
	public void removeDepartmentService(int deptNumber) {
		deptDAO.deleteDepartment(deptNumber);
	}

}
