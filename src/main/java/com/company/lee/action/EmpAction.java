package com.company.lee.action;

import com.company.lee.commons.ResponseResult;
import com.company.lee.commons.Result;
import com.company.lee.dao.pojo.Emp;
import com.company.lee.service.iservice.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpAction {
    @Autowired
    EmpService empService;

    @RequestMapping(value = "emp", method = RequestMethod.POST)
    public @ResponseBody
    ResponseResult<Emp> save(Emp emp) {
        String msg = empService.save(emp);
        int code = Result.SUCCESS.equals(msg) ? 200 : 500;
        return new ResponseResult<Emp>(code, msg);
    }

    @RequestMapping(value = "emp/{empno}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseResult<Emp> update(Emp emp) {
        String msg = empService.update(emp);
        int code = Result.SUCCESS.equals(msg) ? 200 : 500;
        return new ResponseResult<Emp>(code, msg);
    }

    @RequestMapping(value = "emp/{empno}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseResult<Emp> delete(@PathVariable("empno") Integer empno) {
        String msg = empService.delete(empno);
        int code = Result.SUCCESS.equals(msg) ? 200 : 500;
        return new ResponseResult<Emp>(code, msg);
    }

    @RequestMapping("emps")
    public @ResponseBody
    ResponseResult<List<Emp>> findByPage(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "15") int size) {
        List<Emp> emps = empService.findByPage(page, size);
        if (emps != null && emps.size() > 0) {
            return new ResponseResult<List<Emp>>(200, Result.SUCCESS, emps);
        } else {
            return new ResponseResult<List<Emp>>(500, Result.ERROR);

        }

    }

    @RequestMapping("emps/{ename}")
    public @ResponseBody
    ResponseResult<List<Emp>> findByName(@PathVariable("ename") String ename) {
        List<Emp> emps = empService.findByName(ename);
        if (emps != null && emps.size() > 0) {
            return new ResponseResult<List<Emp>>(200, Result.SUCCESS, emps);
        } else {
            return new ResponseResult<List<Emp>>(500, Result.ERROR);

        }

    }

    @RequestMapping("emp/{empno}")
    public @ResponseBody
    ResponseResult<Emp> findById(@PathVariable("empno") Integer empno) {
        Emp emps = empService.findById(empno);
        if (emps != null) {
            return new ResponseResult<Emp>(200, Result.SUCCESS, emps);
        } else {
            return new ResponseResult<Emp>(500, Result.ERROR);

        }

    }

}
