package com.resume.service.setting;

import com.resume.entity.setting.AppSetting;
import com.resume.repository.setting.AppSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppSettingService {

    private final AppSettingRepository appSettingRepository;

    @Autowired
    public AppSettingService(AppSettingRepository appSettingRepository) {
        this.appSettingRepository = appSettingRepository;
    }

    public List<AppSetting> findAll() {
        return this.appSettingRepository.findAll();
    }

    public AppSetting save(AppSetting appSetting) {
        return this.appSettingRepository.save(appSetting);
    }

    public AppSetting findById(Long id) {
        return this.appSettingRepository.findById(id).orElse(null);
    }

    public AppSetting saveOrUpdate(AppSetting appSetting) {
        return this.appSettingRepository.save(appSetting);
    }

    public AppSetting update(AppSetting appSetting) {
        return this.appSettingRepository.save(appSetting);
    }

    public void delete(AppSetting appSetting) {
        this.appSettingRepository.delete(appSetting);
    }

    public AppSetting findOrSave(Long id) {
        AppSetting appSetting = this.appSettingRepository.findById(id).orElse(null);

        if (appSetting == null) {
            appSetting = new AppSetting();
            appSetting.setId(id);
            this.appSettingRepository.save(appSetting);
        }

        return appSetting;
    }
}
