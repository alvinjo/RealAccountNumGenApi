package com.qa.account.util.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.qa.account.util.constants.Constants;

public abstract class AbstractAccountGen {

    private List<String> accountNumList = new ArrayList<>();

    public abstract String getGeneratedNumber();

    protected String generateAccountNumber(int accountLength){
        String generatedAccountNumber = constructString(accountLength);
        while(accountNumList.contains(generatedAccountNumber)){
            generatedAccountNumber = constructString(accountLength);
        }
        accountNumList.add(generatedAccountNumber);
        return generatedAccountNumber;
    }

    private String constructString(int length){
        StringBuilder accNum = new StringBuilder();
        int typeSelector = new Random().nextInt(3);

        if(typeSelector==0){
            accNum.append(Constants.ACCOUNT_TYPE_A);
        }else if(typeSelector==2){
            accNum.append(Constants.ACCOUNT_TYPE_B);
        }else{
            accNum.append(Constants.ACCOUNT_TYPE_C);
        }
        for (int j = 0; j < length; j++) {
            accNum.append(generateDigit());
        }
        return accNum.toString();
    }

    private String generateDigit(){
        return new Random().nextInt(10)+"";
    }
    
    public void setAccountNumList(List<String> accountNumList) {
    	this.accountNumList = accountNumList;
    }
}