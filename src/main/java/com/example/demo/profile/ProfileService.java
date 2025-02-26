package com.example.demo.profile;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfile(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile with id " + id + " not found"));
    }

    public void addNewProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        boolean exists = profileRepository.existsById(id);
        if (!exists) {
            throw new ProfileNotFoundException("Profile with id " + id + " does not exist");
        }
        profileRepository.deleteById(id);
    }

    public void updateProfile(Long profileId, String name, String email) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile with id " + profileId + " not found"));

        if (name != null && !name.isEmpty()) {
            profile.setName(name);
        }

        if (email != null && !email.isEmpty()) {
            profile.setEmail(email);
        }

        profileRepository.save(profile);
    }
    public class ProfileNotFoundException extends RuntimeException {
        public ProfileNotFoundException(String message) {
            super(message);
        }
    }
}
