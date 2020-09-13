package com.unay.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks {
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "username", nullable = false, length = 15)
    private String username;
    @Column(name = "parentid", nullable = true)
    private String parentId;
    @Column(name = "description", nullable = true, length = 100)
    private String description;

    @Override
    public String toString(){
        return "Tasks [id = " + id + ", Username = " + username + ", parentId = " + parentId + ", description = " + description + "]";
    }
}

