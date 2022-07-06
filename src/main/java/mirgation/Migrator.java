package mirgation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Migrator {

	public static void main(String[] args) {
		/*
		 * Tạo đối tượng ServiceRegistry từ file cấu hình hibernate.cfg.xml
		 * 	
		 * Thêm Scope cho cấu hình
         *  1) create - drop if existing schema exists and creates new one everytime
        	2) update - updates the Existing Schema
        	3) validate - validates the Schema and Perform User Operations
        	4) create-drop - creates the schema on session creation and drops the schema at the end of the session 
         */
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .applySetting("hibernate.hbm2ddl.auto", "create-drop") // Mỗi lần chạy là xóa đi tạo mới
                .build();
        
        // Khởi tạo đối tượng mô tả thông tin kết nối
        Metadata metadata = new MetadataSources(serviceRegistry)
      		  .getMetadataBuilder()
      		  .build();
        
        // Tạo phiên kết nối từ đối tượng mô tả    
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
//        session.save(new LoaiSanPham(1,"Yonex"));
        trans.commit();
	}
}
