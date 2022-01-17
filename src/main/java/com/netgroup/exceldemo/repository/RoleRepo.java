package com.netgroup.exceldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netgroup.exceldemo.data.dao.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{

	 Role findByName(String name);
}
