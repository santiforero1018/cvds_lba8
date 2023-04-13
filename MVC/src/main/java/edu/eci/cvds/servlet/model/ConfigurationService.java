package edu.eci.cvds.servlet.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    private final ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository){
        this.configurationRepository = configurationRepository;
    }

    public Configuration addConfiguration(Configuration configuration){
        return configurationRepository.save(configuration);
    }

    public Configuration getConfiguration(String configurationId){
        return configurationRepository.findById(configurationId).get();
    }

    public Configuration updateConfiguration(Configuration configuration){
        if(configurationRepository.existsById(configuration.getProperty())){
            return configurationRepository.save(configuration);
        }

        return null;
    }

    public void deleteConfiguration(String configId){
        configurationRepository.deleteById(configId);
    }
}
