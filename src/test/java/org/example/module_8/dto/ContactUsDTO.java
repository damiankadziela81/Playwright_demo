package org.example.module_8.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContactUsDTO {

    private String subjectHeading;
    private String emailAddress;
    private String orderReference;
    private String fileToUpload;
    private String message;

    public static ContactUsDTO getDefaultContactUsDTO() {
        return ContactUsDTO.builder()
                .subjectHeading("2")
                .emailAddress("tom@gmail.com")
                .orderReference("123")
                .fileToUpload("uploads/sample-text-file.txt")
                .message("test message")
                .build();
    }

}
