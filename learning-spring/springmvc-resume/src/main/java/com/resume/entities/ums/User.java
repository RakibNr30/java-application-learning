package com.resume.entities.ums;

import com.resume.entities.cms.Skill;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Length(min = 3, max = 255)
    private String name;

    @Length(min = 3, max = 65535)
    @Column(length = 65535)
    private String about;

    @NotNull(message = "Date of birth field is required.")
    private LocalDate dob;

    @Length(min = 3, max = 20)
    @ColumnTransformer(read = "username", write = "LOWER(?)")
    @Pattern(regexp = "^[a-zA-Z_][a-zA-Z0-9_-]{3,20}$", message = "Username should be start with letter/underscore, no-space and length between 3 and 20.")
    private String username;

    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^[+]?[0-9]{8,}$", message = "Please enter a minimum 8 digit valid numeric mobile number. It should contain only digits and may start with a '+'.")
    private String mobile;

    @Length(max = 100)
    private String password;

    @Length(min = 3, max = 255)
    private String address;

    private Boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @Fetch(value = FetchMode.SUBSELECT)
    @Size(min = 1)
    private List<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "createdAt")
    private List<Skill> skills;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "endDate DESC")
    private List<UserEducation> userEducations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "endDate DESC")
    private List<UserExperience> userExperiences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "createdAt DESC")
    private List<UserAward> userAwards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "createdAt")
    /*@JoinTable(name = "user_interests", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})*/
    private List<UserInterest> userInterests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "createdAt")
    private List<UserLanguage> userLanguages;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "createdAt")
    private List<UserSocialAccount> userSocialAccounts;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<UserEducation> getUserEducations() {
        return userEducations;
    }

    public void setUserEducations(List<UserEducation> userEducations) {
        this.userEducations = userEducations;
    }

    public List<UserExperience> getUserExperiences() {
        return userExperiences;
    }

    public void setUserExperiences(List<UserExperience> userExperiences) {
        this.userExperiences = userExperiences;
    }

    public List<UserAward> getUserAwards() {
        return userAwards;
    }

    public void setUserAwards(List<UserAward> userAwards) {
        this.userAwards = userAwards;
    }

    public List<UserInterest> getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(List<UserInterest> userInterests) {
        this.userInterests = userInterests;
    }

    public List<UserLanguage> getUserLanguages() {
        return userLanguages;
    }

    public void setUserLanguages(List<UserLanguage> userLanguages) {
        this.userLanguages = userLanguages;
    }

    public List<UserSocialAccount> getUserSocialAccounts() {
        return userSocialAccounts;
    }

    public void setUserSocialAccounts(List<UserSocialAccount> userSocialAccounts) {
        this.userSocialAccounts = userSocialAccounts;
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

    public boolean isEmpty() {
        return this.id == 0;
    }
}
