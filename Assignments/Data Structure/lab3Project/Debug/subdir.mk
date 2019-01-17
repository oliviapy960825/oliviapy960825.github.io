################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../header.cpp \
../hexNumber-main.cpp \
../hexNumber.cpp \
../lab4CommonProblem.cpp \
../third.cpp 

OBJS += \
./header.o \
./hexNumber-main.o \
./hexNumber.o \
./lab4CommonProblem.o \
./third.o 

CPP_DEPS += \
./header.d \
./hexNumber-main.d \
./hexNumber.d \
./lab4CommonProblem.d \
./third.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


