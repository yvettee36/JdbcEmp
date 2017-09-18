package com.chinasofti.dao;

import com.chinasofti.domain.Emp;

import java.util.List;

/**
 * Created by yvettee on 2017/9/17.
 */
public interface EmpDao {
    //部门编号遍历
    List getDeptno();
    //根据部门编号查找雇员信息
    List<Emp> findByDno(int deptno);

}
