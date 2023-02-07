package com.techelevator.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioService {

    private String account_sid = "AC202a198c3c233ca429ba015a14cd5485";
    private String auth_token = "cc7cc507dc5cc63670185ff2f3060bbd";
    private String fromPhoneNumber = "+18887911936";

    public void sendMessage(String toPhoneNumber, String message) {

        Message sms = Message.creator(new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                message).create();
    }


}
