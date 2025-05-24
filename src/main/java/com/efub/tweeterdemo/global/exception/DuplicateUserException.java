package com.efub.tweeterdemo.global.exception;

public class DuplicateUserException extends CustomException {
    public DuplicateUserException(){
      super(ErrorCode.DUPLICATE_USERNAME);
    }
}
