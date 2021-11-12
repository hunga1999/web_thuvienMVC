package com.thuvien.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuvien.model.Sach;

public interface SachDAO extends JpaRepository<Sach, Long>{
	Sach findByid(Long id);	
}
