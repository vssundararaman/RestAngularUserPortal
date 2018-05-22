package com.springrest.userportal.validator;


import com.springrest.userportal.Exception.RestApiException;
import com.springrest.userportal.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator {

    @Value("${default.authid}")
    private String authId;

    public boolean validateAuthorization(String authorizationId) {
        //authorizationId from the header cannot be null or empty. checking that.
        if ((null == authorizationId) || authorizationId.isEmpty()) {
            throwInvalidClientIdException(authorizationId);
        }

        //is authorized  Id
        if (!isAuthorizedId(authorizationId)) {
            throwInvalidClientIdException(authorizationId);
        }
        return true;
    }

    private boolean isAuthorizedId(String authorizationId) {

        return null != authId && authId.equals(authorizationId);
    }

        private void throwInvalidClientIdException(String authorizationId) {

            throw new RestApiException(ErrorResponse.UNAUTHORIZED, null, "UNAUHORIZED_REQUEST", "INVALID AUTHORIZATIONID", HttpStatus.UNAUTHORIZED.toString());
        }
}
