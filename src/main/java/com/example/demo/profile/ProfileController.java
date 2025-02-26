package com.example.demo.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;
    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getProfiles() {
        return profileService.getProfiles();
    }
    @GetMapping(path = "{profileId}")
    public Profile getProfile(@PathVariable("profileId") Long id) {
        return profileService.getProfile(id);
    }
    @PostMapping
    public void registerNewProfile(@RequestBody Profile profile) {
        profileService.addNewProfile(profile);
    }

    @DeleteMapping(path = "{profileId}")
    public void deleteProfile(@PathVariable("profileId") Long id) {
        profileService.deleteProfile(id);
    }
    @PutMapping(path = "{profileId}")
    public void updateProfile(@PathVariable("profileId") Long profileId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        profileService.updateProfile(profileId,name,email);
    }
}
