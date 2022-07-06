package service;

import model.MotobikeCompany;
import reponsitory.CompanyReponsitory;

import java.util.List;

public class MotobikeCompanyService {

    public static List<MotobikeCompany> getAllMotobikeCompany(){
        return CompanyReponsitory.getAllCompany();
    }

    public static void addCategory(MotobikeCompany motobikeCompany) {
        CompanyReponsitory.addCategory(motobikeCompany);
    }

    public static void updateCategory(MotobikeCompany motobikeCompany) {
        CompanyReponsitory.updateCategory(motobikeCompany);
    }

    public static void deleteCategory(int id) {
        CompanyReponsitory.deleteCategory(id);
    }

    public static MotobikeCompany findById(int id) {
        return CompanyReponsitory.findById(id);
    }
}
