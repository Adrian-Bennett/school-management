package za.ac.cput.service;
/*
    IEmployeeAddressService.java
    IEmployee Address Service
    Lana Africa (216166640)
*/
import za.ac.cput.domain.EmployeeAddress;
import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
List<EmployeeAddress> findAll();
    void delete(String id);
}