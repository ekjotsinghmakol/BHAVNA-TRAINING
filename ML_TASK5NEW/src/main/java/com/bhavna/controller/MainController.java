package com.bhavna.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bhavna.bean.EmployeeRecord;
import com.bhavna.dao.EmployeeDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;



@Controller
public class MainController {
    XmlMapper xmlMapper = new XmlMapper();



   @Autowired
    EmployeeDao employeeDao;



   @RequestMapping("/")
    public String home() {
        return "index";
    }



   @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute EmployeeRecord employee) {
        employeeDao.save(employee);
        return "redirect:/viewemp";
    }
    
    @RequestMapping("/viewemp")
    public String viewEmp(Model model) {
        
        List<EmployeeRecord> list = employeeDao.getEmployee();
        model.addAttribute("list", list);
        System.out.println("In Model");
        try {
            String xml = xmlMapper.writeValueAsString(list);
            System.out.println(xml);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "viewemp";
        
    }
    
      @RequestMapping(value="/editemp/{id}")    
        public String edit(@PathVariable int id, Model m){  
            List<EmployeeRecord> list = employeeDao.getEmpById(id);
            System.out.println(list);
            m.addAttribute("list", list);
            return "empid";
               
        }  



}