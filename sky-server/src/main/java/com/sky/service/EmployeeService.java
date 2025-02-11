package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */

    PageResult PageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用和禁用员工账号
     * @param status
     * @param id
     */
    void stopOrstart(Integer status, long id);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    Employee getByid(long id);

    void update(EmployeeDTO employeeDTO);
}
