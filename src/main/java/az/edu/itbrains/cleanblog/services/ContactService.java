package az.edu.itbrains.cleanblog.services;

import az.edu.itbrains.cleanblog.dtos.contact.ContactSendDto;

public interface ContactService {

    void sendEmail(ContactSendDto contactSendDto);
}
