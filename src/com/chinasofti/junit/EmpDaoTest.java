package com.chinasofti.junit;

import com.chinasofti.dao.EmpDao;
import com.chinasofti.dao.impl.EmpDaoImpl;
import com.chinasofti.domain.Emp;
import org.junit.Test;

import java.util.List;

/**
 * Created by yvettee on 2017/9/17.
 */
public class EmpDaoTest {
    @Test
    public void testFindByDno() {
        EmpDao empDao = new EmpDaoImpl();
        List<Emp> list= empDao.findByDno(10);
        for (Emp e : list) {
            System.out.println(e);
        }

    }
}
