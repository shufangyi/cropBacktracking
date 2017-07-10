package com.cbt.system.service;

import java.util.List;

import com.cbt.system.po.AdminInfo;
import com.cbt.system.po.AuthorityInfo;
import com.cbt.system.po.RoleInfo;

public interface RoleInfoService {
	public RoleInfo getRoleAuthority(Integer roleId);
}
