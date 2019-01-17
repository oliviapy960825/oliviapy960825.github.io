function [ results ] = narcissisticNumbers()
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
    results = []
    hDigit = 3
    for tDigit = 0:9
        for oDigit = 0:9
            number=hDigit*100+tDigit*10+oDigit
            rNumber=hDigit^3+tDigit^3+oDigit^3
            if number == rNumber
                results = [results; number]
            end
        end
    end
    
    results = []
    for number = 300:399
        strNum = num2str(number)
        hDigit = str2num(strNum(1))
        tDigit = str2num(strNum(2))
        oDigit = str2num(strNum(3))
        rNumber = hDigit^3+tDigit^3+oDigit^3
        if number == rNumber
            results = [results; number]
        end

end

