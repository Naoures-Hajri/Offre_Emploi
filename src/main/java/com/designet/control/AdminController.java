package com.designet.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.designet.Repository.AdminRepository;
import com.designet.entities.Admin;
import com.designet.service.AdminService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin("*")
@RequestMapping (value = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    private AdminRepository adminRepository;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    @Autowired
    public AdminController(AdminRepository adminRepository) {
    	this.adminRepository= adminRepository;
    	}
    @RequestMapping(method = RequestMethod.POST)
    public Admin ajouterAdmin(@RequestBody Admin admin){
        return adminService.ajouterAdmin(admin);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Admin modifierAdmin(@PathVariable("id")Long id,@RequestBody Admin admin){
        Admin newAdmin=adminService.modifierAdmin(admin);
        return newAdmin;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Admin>getAdminById(@PathVariable("id")Long id){
        Optional<Admin>admin=adminService.getAdminById(id);
        return admin;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerAdmin(@PathVariable("id")Long id){
        adminService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Admin>listAdmin(){
        return adminService.listAdmin();
    }
    
    @PostMapping(path = "registeradmin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        if(adminRepository.existsByEmail(admin.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
        Admin savedUser = adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping(path = "login")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Admin admin) {

        HashMap<String, Object> response = new HashMap<>();

        Admin userFromDB = adminRepository.findAdminByEmail(admin.getEmail());

        if (userFromDB == null) {
            response.put("message", "Admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }  else {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }}
