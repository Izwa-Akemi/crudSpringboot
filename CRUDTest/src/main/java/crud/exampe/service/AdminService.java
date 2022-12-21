package crud.exampe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.exampe.model.dao.AdminDao;
import crud.exampe.model.entity.AdminEntity;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	//一覧取得
    public List<AdminEntity> selectFindAll() {
        return adminDao.findAll();
    }
    
    //内容を保存
    public void insert(String adminName,String adminEmail,String password) {
        adminDao.save(new AdminEntity(adminName,adminEmail,password));
    }
    
  //内容をupdate
    public void update(Long adminId,String adminName,String adminEmail,String password) {
        adminDao.save(new AdminEntity(adminId,adminName,adminEmail,password));
    }
    
  //削除
    public void delete(Long adminId) {
        adminDao.deleteById(adminId);
    }
    
    public AdminEntity selectByAdminId(Long adminId) {
    	  return adminDao.findByAdminId(adminId);

    }
}