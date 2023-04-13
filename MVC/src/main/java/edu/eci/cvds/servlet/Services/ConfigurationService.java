package edu.eci.cvds.servlet.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.servlet.repository.GuessRepository;
import edu.eci.cvds.servlet.model.Configuration;

@Service
public class ConfigurationService {
    private final GuessRepository guessRepository;

    @Autowired
    public ConfigurationService(GuessRepository guessRepository){
        this.guessRepository = guessRepository;
    }

    public Configuration addConfiguration(Configuration configuration){
        return guessRepository.save(configuration);
    }

    public Configuration getConfiguration(Long configurationId){
        return guessRepository.findById(configurationId).get();
    }

    public Configuration updateConfiguration(Configuration configuration){
        if(guessRepository.existsById(configuration.getId())){
            return guessRepository.save(configuration);
        }

        return null;
    }

    public void deleteConfiguration(Long configId){
        guessRepository.deleteById(configId);
    }
}
