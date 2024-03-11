package com.resume.repository.setting;

import com.resume.entity.setting.AppSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSettingRepository extends JpaRepository<AppSetting, Long> {

}
