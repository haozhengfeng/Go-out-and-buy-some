package org.haozf.admin.mapper;

import java.util.List;

import org.haozf.mybatis.model.Admin;

public interface BackAdminMapper {
    List<Admin> listAdmin(Admin admin);
}
