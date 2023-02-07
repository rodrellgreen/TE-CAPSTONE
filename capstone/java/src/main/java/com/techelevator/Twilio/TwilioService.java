package com.techelevator.Twilio;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.OutgoingCallerId;
import com.twilio.rest.api.v2010.account.ValidationRequest;
import com.twilio.type.PhoneNumber;

public class TwilioService {

    private String account_sid = "AC202a198c3c233ca429ba015a14cd5485";
    private String auth_token = "cc7cc507dc5cc63670185ff2f3060bbd";
    private String fromPhoneNumber = "+18887911936";
    private String positiveMessage = "Don't forget to log your food. Your doing Great :)";

    public void sendMessage(String toPhoneNumber) {

        Twilio.init(account_sid, auth_token);

        Message sms = Message.creator(new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                positiveMessage).create();
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
