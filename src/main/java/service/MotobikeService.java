package service;

import java.util.List;

import model.Motobike;
import reponsitory.MotobikeReponsitory;

public class MotobikeService {
	public static List<Motobike> getAllMotobike() {
		return MotobikeReponsitory.getAllMotobike();
	}
	
	public static List<Motobike> getIdMotobike(int cid) {
		return MotobikeReponsitory.getIdMotobike(cid);
	}
	
	public static void addMotobike(Motobike Motobike) {
		MotobikeReponsitory.addMotobike(Motobike);
	}

	public static void updateMotobike(Motobike Motobike) {
		MotobikeReponsitory.updateMotobike(Motobike);
	}

	public static void deleteMotobike(int id) {
		MotobikeReponsitory.deleteMotobike(id);
	}

	public static Motobike findById(int id) {
		return MotobikeReponsitory.findById(id);
	}

	public List<Motobike> searchByName(String name) {
		return MotobikeReponsitory.searchByName(name);
	}
}
