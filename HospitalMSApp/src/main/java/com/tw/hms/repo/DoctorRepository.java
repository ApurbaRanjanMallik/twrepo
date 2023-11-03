package com.tw.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tw.hms.entity.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>{
	@Modifying
	@Query("UPDATE DoctorEntity de SET de.docDept=:docDept where de.id=:id")
	Integer updateDateDocDeptById(Long id, String docDept);

}
