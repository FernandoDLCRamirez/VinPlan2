package com.narval.Models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "Usuario", schema="vin-plan")
public class Usuario {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username", length=50, nullable=false, unique=false)
    private String username;

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="lastname", length=50, nullable=false, unique=false)
    private String lastname;

    @Column(name="hashed_password", length=100, nullable=false, unique=false)
    private String hashed_password;

    @Column(name="email", length=254, nullable=false, unique=false)
    private String email;
    
    @Column(name="active", nullable=false)
	private int active;        
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",
    joinColumns=@JoinColumn(name="usuario_id"), inverseJoinColumns = @JoinColumn(name="roles_id"))
    private Set<Roles> roles=new HashSet<>();
    
    public Set<Roles> getRoles(){
    	return this.roles;
    }

    
    public void addRoll(Roles rol) {
    	this.roles.add(rol);
    }
 
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String string) {
        this.username= string;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHashed_password() {
        return this.hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
	public int isActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	
	



}
