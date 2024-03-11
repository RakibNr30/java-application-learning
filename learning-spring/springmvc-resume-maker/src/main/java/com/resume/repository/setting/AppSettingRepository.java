package com.resume.repository.setting;

import com.resume.document.setting.AppSetting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppSettingRepository extends MongoRepository<AppSetting, Long> {
}
