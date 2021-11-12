package com.thuvien.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thuvien.model.Thanhvien;

@Repository
public interface ThanhvienDAO extends JpaRepository<Thanhvien, Long>{
	
	Thanhvien findBytenDN(String tenDN);
}
