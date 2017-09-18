package com.chinasofti.service;

import com.chinasofti.domain.Emp;

import java.util.List;

/**
 * Created by yvettee on 2017/9/17.
 */
public interface EmpService {
    List getDeptno();
    List<Emp> findByDno(int deptno);
}
