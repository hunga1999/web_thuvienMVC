package com.thuvien.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thuvien.model.Muonsach;

@Repository
public interface MuonsachDAO extends JpaRepository<Muonsach, Long>{
	
	List<Muonsach> findByIDDG(Long IDDG);

}
