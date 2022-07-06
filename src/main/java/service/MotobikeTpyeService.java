package service;

import model.MotobikeType;
import reponsitory.TypeReponsitory;

import java.util.List;

public class MotobikeTpyeService {
        public static List<MotobikeType> getAllMotobikeType(){
            return TypeReponsitory.getAllType();
        }
}
