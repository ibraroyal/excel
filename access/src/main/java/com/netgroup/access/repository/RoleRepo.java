package com.netgroup.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netgroup.access.data.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{

	 Role findByName(String name);
}
