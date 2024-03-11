package com.resume.document.setting;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@Document(collection = "app_settings")
public class AppSetting {

    @Id
    private Long id;

    @NotBlank
    @Column(name = "app_name")
    private String appName;

    @NotBlank
    @Column(name = "app_title")
    private String appTitle;
}
