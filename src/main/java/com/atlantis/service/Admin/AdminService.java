package com.atlantis.service.Admin;

import com.atlantis.model.Admin.Admin;
import com.atlantis.repository.Admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmin(){
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdmin(String id){
        return adminRepository.findAdminById(id);
    }

    public void addNewAdmin(Admin admin) {
        Optional<Admin> AdminByID = adminRepository.findAdminById(admin.getAdminId());
        if(AdminByID.isPresent()){
            throw new IllegalStateException(
                    "There is already a Admin with the given id!");
        }
        adminRepository.save(admin);
        System.out.println(admin);
    }
    public void deleteAdmin(String adminId) {
        boolean exist =adminRepository.existsById(adminId);
        if(!exist){
            throw new IllegalStateException(
                    "Admin with id="+ adminId+ " does not exist!");
        }
        adminRepository.deleteById(adminId);
    }

}
