package com.thuvien.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuvien.model.Docgia;

public interface DocgiaDAO extends JpaRepository<Docgia, Long>{
	
	Docgia findByid(Long id);

}
