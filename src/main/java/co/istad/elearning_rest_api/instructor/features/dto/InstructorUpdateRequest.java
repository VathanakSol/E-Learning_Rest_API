package co.istad.elearning_rest_api.instructor.features.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public record InstructorUpdateRequest(
        String biography,
        String github,
        boolean isBlocked,
        String jobTitle,
        String linkedIn,
        String website
) {
    public String getBiography() {
        return biography;
    }

    public String getGithub() {
        return github;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public String getWebsite() {
        return website;
    }
}
