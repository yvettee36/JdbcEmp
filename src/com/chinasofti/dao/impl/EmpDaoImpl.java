package com.chinasofti.dao.impl;

import com.chinasofti.dao.EmpDao;
import com.chinasofti.domain.Emp;
import com.chinasofti.utils.JdbcUtilsSingle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yvettee on 2017/9/17.
 */
public class EmpDaoImpl implements EmpDao {

    @Override
    public List<Emp> findByDno(int deptno) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Emp> list = new ArrayList();

        try {
            conn = JdbcUtilsSingle.getInstance().getConnection();
            String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptno);
            rs = ps.executeQuery();
            while (rs.next()) {
                Emp e = mappingEmp(rs);
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsSingle.getInstance().release(rs, ps, conn);
        }
        return list;
    }

    private Emp mappingEmp(ResultSet rs) throws SQLException {
        Emp e = new Emp();
        e.setEmpno(rs.getInt("empno"));
        e.setEname(rs.getString("ename"));
        e.setJob(rs.getString("job"));
        e.setMgr(rs.getInt("mgr"));
        e.setHireDate(rs.getDate("hiredate"));
        e.setSal(rs.getDouble("sal"));
        e.setComm(rs.getDouble("comm"));
        e.setDeptno(rs.getInt("deptno"));
        return e;
    }

    @Override
    public List getDeptno() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List list = new ArrayList();

        try {
            conn = JdbcUtilsSingle.getInstance().getConnection();
            String sql = "select distinct deptno from emp";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("deptno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsSingle.getInstance().release(rs, ps, conn);
        }
        return list;
    }
}
