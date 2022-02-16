package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.User;
import com.example.demo.entity.dto.APIResponse;
import com.example.demo.entity.dto.Userdto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserDetailsServiceImpl;
import com.sipios.springsearch.anotation.SearchSpec;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class Usercontroller {
	
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;
	
	@Autowired
	private UserRepository urepo;
	

		@GetMapping
	    public List<User> getAll() {
	        return detailsServiceImpl.getAll();
	    }
		
//		@GetMapping("/{keyword}")
//		public ResponseEntity<List<User>> viewHomePage(Model m,Userdto model, @PathVariable("keyword") String keyword) {
//	       // List<User> listProducts = detailsServiceImpl.searchuser(keyword);
//	       // m.addAttribute("listProducts", listProducts);
//	        m.addAttribute("keyword", keyword);
//	         System.out.println("hello ganesh");
//	        return ResponseEntity.ok().body(detailsServiceImpl.searchuser(keyword));
//	    }
		
		 @GetMapping("/user")
		    public ResponseEntity<List<User>> searchForCars(@SearchSpec Specification<User> specs) {
		        return new ResponseEntity<>(urepo.findAll(Specification.where(specs)), HttpStatus.OK);
		    }
		
		@GetMapping(value="get/{emailId}")
		public ResponseEntity<User> getUserByEmailid(@Valid @PathVariable String emailId) {
			
			return ResponseEntity.ok().body(detailsServiceImpl.getUserByEmalId(emailId));
		}
		
		@GetMapping(value="/{id}")
		public ResponseEntity<User> getUserById(@Valid @PathVariable int id) {
			return ResponseEntity.ok().body(detailsServiceImpl.getUserById(id));
		}
		
		@GetMapping(value="sort/{field}")
	    public APIResponse<List<User>> getProductsWithSort(@PathVariable String field) {
			System.out.println("hello ganesh");
	        List<User> allProducts = detailsServiceImpl.findProductsWithSorting(field);
	        return new APIResponse<>(allProducts.size(), allProducts);
	    }

	    @GetMapping("/pagination/{offset}/{pageSize}")
	    private APIResponse<Page<User>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	    	System.out.println("hello ganesh");
	        Page<User> productsWithPagination = detailsServiceImpl.findProductsWithPagination(offset, pageSize);
	        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	    }

	    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	    private APIResponse<Page<User>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
	        Page<User> productsWithPagination = detailsServiceImpl.findProductsWithPaginationAndSorting(offset, pageSize, field);
	        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	    }

		
		
		
		
		@PutMapping("/{id}")
		public ResponseEntity<User> update(@Valid @RequestBody Userdto users,@PathVariable int id) {
			users.setId(id);
			
			return ResponseEntity.ok().body(detailsServiceImpl.update(users));
			}
			
		
		
			@DeleteMapping("/{id}")
			public void deleteusers(@Valid @PathVariable ("id") int id) {
				detailsServiceImpl.delete(id);
			}
		
	        
		}