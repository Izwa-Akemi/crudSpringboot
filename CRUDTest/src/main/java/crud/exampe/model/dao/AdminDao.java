package crud.exampe.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.exampe.model.entity.AdminEntity;

@Repository
public interface AdminDao extends JpaRepository<AdminEntity, Long> {
	//データの内容を保存
	AdminEntity save(AdminEntity adminEntity);
	//一覧取得
	List<AdminEntity> findAll();
	//idを見つける
	AdminEntity findByAdminId(Long adminId);
	
}
