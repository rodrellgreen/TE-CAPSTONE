package com.techelevator.Twilio;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.OutgoingCallerId;
import com.twilio.rest.api.v2010.account.ValidationRequest;
import com.twilio.type.PhoneNumber;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TwilioService {
    //MG487e2275c0daca26a39d2fa6283dd2b3
//
    private String account_sid = "AC202a198c3c233ca429ba015a14cd5485";
    private String account_sid2 = System.getenv("MG487e2275c0daca26a39d2fa6283dd2b3");
    private String auth_token = "cc7cc507dc5cc63670185ff2f3060bbd";
    private String auth_token2 = System.getenv("cc7cc507dc5cc63670185ff2f3060bbd");
//
    private String fromPhoneNumber = "+18887911936";
    private String positiveMessage = "Hello From Tech Fitness Pal! THE BETTER ONE! *Trademark still pending* Don't forget to log your food. You're doing GREAT :) Keep up the good work!";
    private String lessThan15Message = "Hello From Tech Fitness Pal! THE BETTER ONE! *Trademark still pending* Looks like you tried to set a reminder for yourself. Unfortunately you can't set messages less than 15 minutes from the future. Please reenter your desired date and time. ";

    public void sendMessage(String toPhoneNumber) {

        Twilio.init( account_sid,  auth_token);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(toPhoneNumber),
                new com.twilio.type.PhoneNumber(fromPhoneNumber),
                lessThan15Message).create();
    }

    public void sendMessageAtTime(String toPhoneNumber, LocalDateTime dt) {

        Twilio.init(account_sid, auth_token);

        Message sms = Message.creator(
                new com.twilio.type.PhoneNumber(toPhoneNumber),
                "MG487e2275c0daca26a39d2fa6283dd2b3",
                positiveMessage)
                .setSendAt(   ZonedDateTime.of(dt.getYear(), dt.getMonthValue(), dt.getDayOfMonth(), dt.getHour(), dt.getMinute(), dt.getSecond(), 0, ZoneId.of("US/Eastern"))    )
                .setScheduleType(Message.ScheduleType.FIXED)
                .create();
    }

    public void verifyUser(String toPhoneNumber){{
        Twilio.init(account_sid, auth_token);
        ValidationRequest validationRequest = ValidationRequest.creator(
                        new com.twilio.type.PhoneNumber(toPhoneNumber))
                .setFriendlyName("Tech Fitness User")
                .create();
    }
    }
}
