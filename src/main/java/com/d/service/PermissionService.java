package com.d.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.d.base.BaseService;
import com.d.entity.Permission;
import com.d.mapper.PermissionMapper;

/**
 * @author d
 */
@Service
public class PermissionService extends BaseService<PermissionMapper, Permission> {
	public List<Permission> listByRoleId(Integer roleId) {
		return mapper.listByRoleId(roleId);
	}

	@Override
	public List<Permission> findAll() {
		return mapper.listNormal();
	}

	public Integer updateOriginal(int parentId, int index) {
		return mapper.updateOriginal(parentId, index);
	}

	public Integer updateTarget(int parentId, int index) {
		return mapper.updateTarget(parentId, index);
	}
	
	public Integer countByParentId(int parentId){
		return mapper.countByParentId(parentId);
	}
}