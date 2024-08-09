package com.demo.springboot_model_mapper_project;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController 
{
 
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	ModelMapper modelmapper;//check the modelmapperconfiguration
	
	@RequestMapping("/test")
	public String test()
	{
		return "Test is completed";
	}
	@RequestMapping("/save")
     public CustomerDTO save(@RequestBody CustomerDTO customerdto)
     {
		Customer customer=new Customer();
		modelmapper.map(customerdto,customer);
		//BeanUtils.copyProperties(customerdto,customer);
		repo.save(customer);
		return customerdto;
		
     }
	@RequestMapping("/all")
	public List<CustomerDTO> allData()
	{
		return repo.findAll().stream().map(customer->modelmapper.map(customer,CustomerDTO.class))
		.collect(Collectors.toList());//changing to list
					
	}
}
