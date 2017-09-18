package com.chinasofti.service.impl;

import com.chinasofti.dao.EmpDao;
import com.chinasofti.dao.impl.EmpDaoImpl;
import com.chinasofti.domain.Emp;
import com.chinasofti.service.EmpService;

import java.util.List;

/**
 * Created by yvettee on 2017/9/17.
 */
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();

    @Override
    public List getDeptno() {
        return empDao.getDeptno();
    }

    @Override
    public List<Emp> findByDno(int deptno) {
        return empDao.findByDno(deptno);
    }
}
