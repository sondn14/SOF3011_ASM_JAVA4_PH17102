package service;

import model.MotobikeColor;
import reponsitory.ColorReponsitory;

import java.util.List;

public class MotobikeColorService {
    public static List<MotobikeColor> getAllMotobikeColor(){
        return ColorReponsitory.getAllColor();
    }
}
