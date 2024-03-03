package com.resume.entity.cms;

import com.resume.entity.ums.UserSkill;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 255)
    private String name;

    @Length(min = 3, max = 65535)
    @Column(length = 65535)
    private String details;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy(value = "proficiency, createdAt")
    private List<UserSkill> userSkills;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<UserSkill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<UserSkill> userSkills) {
        this.userSkills = userSkills;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id);
    }

    public boolean isEmpty() {
        return this.id == 0;
    }
}
